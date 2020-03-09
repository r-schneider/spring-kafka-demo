package com.springkafka.messenger.domain.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.springkafka.messenger.domain.model.Book;

import org.springframework.stereotype.Component;

@Component
public class BookRepositoryImpl implements BookRepository {

    List<Book> books = new ArrayList<>();

    @PostConstruct
    public void initData() {
        List<Book> booksList = Arrays.asList(
                new Book("Hogwarts", "J.K.Rowling", "A new generation...", "NewAge", "2020", 11111L, 56.00f),
                new Book("Kaer Morhen", "Andrzej Sapkowski", "Home for...", "Wishmaster", "2020", 22222L, 49.99f),
                new Book("Chronosphere", "Rilay Maiden", "Locked in time...", "Void", "2012", 33333L, 42.00f),
                new Book("Empty Mirrors", "Zeni Sanders", "A lost soul...", "Blank", "2015", 44444L, 22.50f),
                new Book("The Wall", "Eren Jagger", "After an attack...", "Wolfsbane", "2011", 55555L, 37.25f));
        for (Book book : booksList) {
            books.add(book);
        }
    }

    @Override
    public Optional<Book> findByIsbn(long isbn) {
        List<Book> result = books.stream().filter(book -> book.getIsbn() == isbn).collect(Collectors.toList());
        return (result.size() > 0) ? Optional.of(result.get(0)): Optional.empty();
    }
}