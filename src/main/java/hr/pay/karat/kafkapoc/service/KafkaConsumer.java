package hr.pay.karat.kafkapoc.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "#{'${spring.kafka.consumer.topic}'}",
            groupId = "#{'${spring.kafka.consumer.group-id}'}")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
