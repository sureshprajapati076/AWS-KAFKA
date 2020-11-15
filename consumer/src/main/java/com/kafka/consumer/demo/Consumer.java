package com.kafka.consumer.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
public class Consumer {


    @KafkaListener(topics = "${my.topic.kafka:default-topic}", groupId = "groupId")
    public void consume(String message) {
        System.out.println("MESSAGE RECEIVED at "+ LocalDateTime.now(ZoneId.of("America/Chicago")).format(DateTimeFormatter.ofPattern("HH:mm:ss a")) + " CONTENT:  "+message);
    }

}
