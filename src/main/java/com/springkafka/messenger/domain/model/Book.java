package com.springkafka.messenger.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {

    private String title;
    private String author;
    private String description;
    private int year;
    private int isbn;
    private int price;

}