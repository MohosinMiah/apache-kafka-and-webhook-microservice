package com.paymentkafka.paymentkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paymentkafka.paymentkafka.kafka.KafkaProducer;

@RestController
public class PaymentWebhookController {

    @Autowired
    private KafkaProducer kafkaProducer;


    @GetMapping("/publish")
    public ResponseEntity<String> sendPaymentWehbHookNotification(@RequestBody String paymentEvent){
        kafkaProducer.sendWebHookMessage(paymentEvent);
        return ResponseEntity.ok("Message sent to kafka topic");
    } 
}
