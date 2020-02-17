package com.springkafka.messenger.application.controller;

import com.springkafka.messenger.domain.model.Book;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
public interface BookController {

    @GetMapping(value = "/{isbn}")
    Book getBookDetails(@PathVariable long isbn);
}