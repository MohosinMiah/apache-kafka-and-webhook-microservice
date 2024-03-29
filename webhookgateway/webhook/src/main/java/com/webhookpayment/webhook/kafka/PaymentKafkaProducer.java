package com.webhookpayment.webhook.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.webhookpayment.webhook.utils.AppConstants;


@Service
public class PaymentKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentKafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendWebHookMessage(String message){
        LOGGER.info(String.format("Message sent from WebHook To Kafka for Log Storage -> %s", message));
        kafkaTemplate.send(AppConstants.TOPIC_NAME, message);
    }
}