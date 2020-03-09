package com.springkafka.messenger.application.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookEventListener {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final String topic;

    @Autowired
    public BookEventListener(KafkaTemplate<String, Object> kafkaTemplate,
            @Value("${application.kafka.topic}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @EventListener(BookEvent.class)
    public void whenBookIsRequested(BookEvent event) {
            kafkaTemplate.send(topic, event.hashCode() + "", event);
            log.info("Sent to Kafka: {}", event);
    }
}
