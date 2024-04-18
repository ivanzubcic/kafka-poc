package hr.pay.karat.kafkapoc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.producer.topic}")
    private String producerTopic;

    public void sendMessage(String topic, String msg) {
        topic = (topic != null && !topic.isEmpty()) ? topic : producerTopic;

        kafkaTemplate.send(topic, msg);
    }
}
