package com.consumer2.demo;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
public class Consumer2 {


    @KafkaListener(topics = "${my.topic.kafka:default-topic}", groupId = "groupId2")
    public void consume(String message) {
        System.out.println("MESSAGE RECEIVED at CONSUMER 2"+ LocalDateTime.now(ZoneId.of("America/Chicago")).format(DateTimeFormatter.ofPattern("HH:mm:ss a")) + " CONTENT:  "+message);
    }

}
