package com.springkafka.messenger.application.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springkafka.messenger.domain.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({ "source", "timestamp" })
public class BookEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    private Book book;
    private long requestStart;
    private long requestEnd;

    @Autowired
    public BookEvent(Object source) {
        super(source);
        this.requestStart = System.currentTimeMillis();
    }

    public void end(Book book) {
        this.book = book;
        this.requestEnd = System.currentTimeMillis();
    }
}

    