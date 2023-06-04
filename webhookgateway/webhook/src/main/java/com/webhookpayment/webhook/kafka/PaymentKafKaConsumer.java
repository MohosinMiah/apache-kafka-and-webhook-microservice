package com.webhookpayment.webhook.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webhookpayment.webhook.entity.WebHook;
import com.webhookpayment.webhook.repository.WebHookRepository;


@Service
public class PaymentKafKaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentKafKaConsumer.class);

    public static final String TOPIC_NAME = "paymentkafka";
    public static final String GROUP_ID = "paymentkafka_payment";


    @Autowired
    WebHookRepository webHookRepository;

    @Autowired
    PaymentKafkaProducer kafkaProducer;

    @KafkaListener(topics = TOPIC_NAME,
                    groupId = GROUP_ID)
    public ResponseEntity<String> consume(String message){
        LOGGER.info(String.format("Message received from Webhook Microservice -> %s", message));
        try {
            JsonNode rootNode = new ObjectMapper().readTree(message);
            String eventName = rootNode.path("eventName").asText();
            String status = rootNode.path("status").asText();

            // Insert Data
            WebHook webHook = new WebHook();
            webHook.setEventName(eventName);
            webHook.setStatus(status);
            webHook.setPayload(message);
            webHookRepository.save(webHook);

            // Send Notification to Kafka Log Microservice
            kafkaProducer.sendWebHookMessage(message);
         

    } catch (Exception e) {
        // Handle any exceptions that occur during JSON parsing
        return ResponseEntity.badRequest().body("Error processing JSON data");
    }
        return null;

      

    }
}