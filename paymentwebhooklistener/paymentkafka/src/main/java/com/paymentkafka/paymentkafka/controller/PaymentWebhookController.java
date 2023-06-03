package com.paymentkafka.paymentkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paymentkafka.paymentkafka.kafka.KafkaProducer;

@RestController
public class PaymentWebhookController {

    @Autowired
    private KafkaProducer kafkaProducer;


    @GetMapping("/publish")
    public ResponseEntity<String> sendPaymentWehbHookNotification(@RequestBody String paymentEvent){

        kafkaProducer.sendWebHookMessage(paymentEvent);
        return ResponseEntity.ok("Payment Event: " + paymentEvent );

        // try {
        //     JsonNode rootNode = new ObjectMapper().readTree(paymentEvent);
        //     String companyNumber = rootNode.path("companyNumber").asText();
        //     // So we can get any value 
        //     kafkaProducer.sendWebHookMessage(companyNumber);

        //     return ResponseEntity.ok("companyNumber Number: " + companyNumber );

        // } catch (Exception e) {
        //     // Handle any exceptions that occur during JSON parsing
        //     return ResponseEntity.badRequest().body("Error processing JSON data");
        // }
    } 
}
