package com.kafka.producer.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@RestController
public class ProducerController {
    @Autowired
    private Producer producer;


    @PostMapping("/send")
    public String sendMessage(@RequestBody MessageDto message){
        producer.sendMessage(message.getMessage());
        return "Message Sent Successful!!! at "+ LocalDateTime.now(ZoneId.of("America/Chicago")).format(DateTimeFormatter.ofPattern("HH:mm:ss a"));
    }


}
