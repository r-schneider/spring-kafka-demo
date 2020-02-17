package com.springkafka.messenger.application.service;

import java.util.Optional;

import com.springkafka.messenger.domain.model.Book;
import com.springkafka.messenger.domain.repository.BookRepository;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    BookRepository repository;

    public BookServiceImpl (BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book findBookByIsbn(long isbn) {
        Optional<Book> book = repository.findByIsbn(isbn);
        return (book.isPresent()) ? book.get() : null;
    }
}