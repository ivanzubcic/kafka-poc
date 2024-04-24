package hr.pay.karat.kafkapoc.controller;

import hr.pay.karat.kafkapoc.dto.KafkaMessage;
import hr.pay.karat.kafkapoc.dto.Merchant;
import hr.pay.karat.kafkapoc.dto.MerchantSalePoint;
import hr.pay.karat.kafkapoc.dto.PosData;
import hr.pay.karat.kafkapoc.service.KafkaProducer;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class KafkaApi {

    private final KafkaProducer kafkaProducer;

    public KafkaApi(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/producer")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Object> sendMessage(@RequestBody final KafkaMessage kafkaMessage){
        kafkaProducer.sendMessage(kafkaMessage.getTopic(), kafkaMessage.getMessage());
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/merchant")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Object> createMerchant(@RequestBody final Merchant merchant){
        kafkaProducer.createMerchant(merchant);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/merchantSalePoint")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Object> createMerchantSalePoint(@RequestBody final MerchantSalePoint merchantSalePoint){
        kafkaProducer.createMerchantSalePoint(merchantSalePoint);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/pos")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Object> createPos(@RequestBody final PosData posData){
        kafkaProducer.createPos(posData);
        return ResponseEntity.accepted().build();
    }
}
