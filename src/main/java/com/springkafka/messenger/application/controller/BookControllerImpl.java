package com.springkafka.messenger.application.controller;

import com.springkafka.messenger.application.event.BookEvent;
import com.springkafka.messenger.application.service.BookService;
import com.springkafka.messenger.application.service.EventNotification;
import com.springkafka.messenger.domain.model.Book;

import org.springframework.web.bind.annotation.RestController;

import lombok.var;

@RestController
public class BookControllerImpl implements BookController {

    BookService service;
    EventNotification eventNotification;

    public BookControllerImpl(BookService service, EventNotification eventNotification) {
        this.service = service;
        this.eventNotification = eventNotification;
    }

    @Override
    public Book getBookDetails(long isbn) {
        var event = new BookEvent(this);
        var book = service.findBookByIsbn(isbn);
        event.end(book);
        eventNotification.fireBookEvent(event);
        return book;
    }
}