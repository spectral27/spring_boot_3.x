package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ExampleListener {

    private static final Logger log = LoggerFactory.getLogger(ExampleListener.class);

    @KafkaListener(topics = "springtopic", groupId = "groupid")
    public void listener(String received) {
        log.info(received);
    }

}
