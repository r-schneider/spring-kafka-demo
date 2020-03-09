package com.springkafka.messenger.application.service;

import com.springkafka.messenger.application.event.BookEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.stereotype.Service;

@Service
public class EventNotificationImpl implements EventNotification {

    private final ApplicationEventMulticaster applicationEventMulticaster;

    @Autowired
    public EventNotificationImpl(ApplicationEventMulticaster applicationEventMulticaster) {
        this.applicationEventMulticaster = applicationEventMulticaster;
    }

    @Override
    public void fireBookEvent(BookEvent event) {
        applicationEventMulticaster.multicastEvent(event);
    }
}
