package com.springkafka.messenger.application.controller;

import com.springkafka.messenger.application.service.BookServiceImpl;

import org.springframework.stereotype.Controller;

@Controller
public class BookControllerImpl {

    BookServiceImpl service;

    public BookControllerImpl(BookServiceImpl service) {
        this.service = service;
    }
}