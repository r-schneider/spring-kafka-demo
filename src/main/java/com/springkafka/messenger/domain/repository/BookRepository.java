package com.springkafka.messenger.domain.repository;

import java.util.Optional;

import com.springkafka.messenger.domain.model.Book;

public interface BookRepository {
    
    Optional<Book> findByIsbn(long isbn);
}