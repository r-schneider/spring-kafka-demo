package com.springkafka.messenger.application.service;

import com.springkafka.messenger.application.event.BookEvent;

public interface EventNotification {

    void fireBookEvent(BookEvent event);
}
