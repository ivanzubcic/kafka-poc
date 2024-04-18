package hr.pay.karat.kafkapoc.controller;

import hr.pay.karat.kafkapoc.dto.KafkaMessage;
import hr.pay.karat.kafkapoc.service.KafkaProducer;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/kafka", produces = MediaType.APPLICATION_JSON_VALUE)
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


}
