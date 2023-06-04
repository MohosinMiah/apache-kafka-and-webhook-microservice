package com.paymentkafka.paymentkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.paymentkafka.paymentkafka.utils.AppConstants;

@Service
public class PaymentKafKaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentKafKaConsumer.class);
    public static final String TOPIC_NAME = "webhook_paymentkafka";
    public static final String GROUP_ID = "webhook_paymentkafka_payment";

    @KafkaListener(topics = TOPIC_NAME,
                    groupId = GROUP_ID)
    public void consume(String message){
        LOGGER.info("Hi, This is FROM BD Team. This message will receive from Kafka that will send for log Storage");
    }
}