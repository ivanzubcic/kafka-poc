package hr.pay.karat.kafkapoc.service;

import hr.pay.karat.kafkapoc.dto.Merchant;
import hr.pay.karat.kafkapoc.dto.MerchantSalePoint;
import hr.pay.karat.kafkapoc.dto.PosData;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@KafkaListener(topics = "#{'${spring.kafka.consumer.topic}'}")
public class KafkaConsumer {

//    @KafkaListener(topics = "#{'${spring.kafka.consumer.topic}'}",
//            groupId = "#{'${spring.kafka.consumer.group-id}'}")
//    public void listen(String message) {
//        System.out.println("Received message: " + message);
//    }
//
//    @KafkaListener(topics = "#{'${spring.kafka.consumer.topic}'}",
//            groupId = "#{'${spring.kafka.consumer.group-id}'}",
//            containerFactory = "merchantKafkaListenerContainerFactory")
//    public void merchantListener(Merchant merchant) {
//        System.out.println("Received merchant: " + merchant.getName());
//    }


    @KafkaHandler
    public void handleMerchant(Merchant merchant) {
        System.out.println("Merchant received: " + merchant.getName());
    }

    @KafkaHandler
    public void handleMerchantSalePoint(MerchantSalePoint merchantSalePoint) {
        System.out.println("MerchantSalePoint received: " + merchantSalePoint.getName());
    }

    @KafkaHandler
    public void handlePosData(PosData posData) {
        System.out.println("PosData received: " + posData.getName());
    }

    @KafkaHandler(isDefault = true)
    public void unknown(Object object) {
        System.out.println("Unkown type received: " + object);
    }
}
