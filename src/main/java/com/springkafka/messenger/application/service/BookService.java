package com.springkafka.messenger.application.service;

import com.springkafka.messenger.domain.model.Book;

public interface BookService {

    Book findBookByIsbn(long isbn);

    
}