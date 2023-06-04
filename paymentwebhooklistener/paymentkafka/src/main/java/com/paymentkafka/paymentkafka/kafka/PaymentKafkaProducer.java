package com.paymentkafka.paymentkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.paymentkafka.paymentkafka.utils.AppConstants;

@Service
public class PaymentKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentKafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendWebHookMessage(String message){
        LOGGER.info(String.format("Message sent After Receive Payment Gateway -> %s", message));
        kafkaTemplate.send(AppConstants.TOPIC_NAME, message);
    }
}