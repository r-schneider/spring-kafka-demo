package com.springkafka.messenger.application.controller;

import com.springkafka.messenger.application.service.BookService;
import com.springkafka.messenger.domain.model.Book;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookControllerImpl implements BookController {

    BookService service;

    public BookControllerImpl(BookService service) {
        this.service = service;
    }

    @Override
    public Book getBookDetails(long isbn) {
        return service.findBookByIsbn(isbn);
    }
}