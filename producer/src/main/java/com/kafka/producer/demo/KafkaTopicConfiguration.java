package com.kafka.producer.demo;


import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfiguration {

    @Value("${my.topic.kafka:default-topic}")
    private String topic;

    @Bean
    public KafkaAdmin admin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "b-1.kafkalive.jz7rv5.c9.kafka.us-east-1.amazonaws.com:9092,b-4.kafkalive.jz7rv5.c9.kafka.us-east-1.amazonaws.com:9092,b-2.kafkalive.jz7rv5.c9.kafka.us-east-1.amazonaws.com:9092");
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic compactTopicExample() {
        return TopicBuilder.name(topic)
                .partitions(6)
                .replicas(3)
                .build();
    }
}
