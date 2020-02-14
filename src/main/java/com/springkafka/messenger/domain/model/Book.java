package com.springkafka.messenger.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {

    private String title;
    private String author;
    private String description;
    private String publisher;
    private String year;
    private long isbn;
    private float price;

}