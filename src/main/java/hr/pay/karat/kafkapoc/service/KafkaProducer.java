package hr.pay.karat.kafkapoc.service;

import hr.pay.karat.kafkapoc.dto.Merchant;
import hr.pay.karat.kafkapoc.dto.MerchantSalePoint;
import hr.pay.karat.kafkapoc.dto.PosData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Object> multiTypeKafkaTemplate;

//    @Autowired
//    private KafkaTemplate<String, Merchant> merchantKafkaTemplate;
//
//    @Autowired
//    private KafkaTemplate<String, MerchantSalePoint> merchantSalePointKafkaTemplate;
//
//    @Autowired
//    private KafkaTemplate<String, PosData> posDataKafkaTemplate;

    @Value("${spring.kafka.producer.topic}")
    private String producerTopic;

    public void sendMessage(String topic, String msg) {
        topic = (topic != null && !topic.isEmpty()) ? topic : producerTopic;

        multiTypeKafkaTemplate.send(topic, msg);
    }

    public void createMerchant(Merchant merchant) {
        multiTypeKafkaTemplate.send(producerTopic, merchant);
    }

    public void createMerchantSalePoint(MerchantSalePoint merchantSalePoint) {
        multiTypeKafkaTemplate.send(producerTopic, merchantSalePoint);
    }

    public void createPos(PosData posData) {
        multiTypeKafkaTemplate.send(producerTopic, posData);
    }
}
