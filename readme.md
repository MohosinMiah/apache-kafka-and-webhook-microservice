## How to Install

## First run docker in your local machine

<code>docker compose up -d</code>

<small> This command will run Apache Kafka as in the root we configure Dockerfile for Kafka run in Docker </small>
<code>
version: '3'
services:
  zookeeper:
    image: confluentinc/cp-zookeeper:7.3.2
    container_name: zookeeper
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000
  broker:
    image: confluentinc/cp-kafka:7.3.2
    container_name: broker
    ports:
      - "9092:9092"
    depends_on:
      - zookeeper
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: 'zookeeper:2181'
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_INTERNAL:PLAINTEXT
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092,PLAINTEXT_INTERNAL://broker:29092
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
      KAFKA_TRANSACTION_STATE_LOG_MIN_ISR: 1
      KAFKA_TRANSACTION_STATE_LOG_REPLICATION_FACTOR: 1
</code>

## Configure Payment Webhook Listner Project

## configure application.properties

# Apache Kafka Configuration
spring.kafka.consumer.bootstrap-servers: localhost:9092
spring.kafka.consumer.group-id: paymentkafka_payment
spring.kafka.consumer.auto-offset-reset: earliest
spring.kafka.consumer.key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer: org.apache.kafka.common.serialization.StringDeserializer



spring.kafka.producer.bootstrap-servers: localhost:9092
spring.kafka.producer.key-serializer: org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer: org.apache.kafka.common.serialization.StringSerializer




## Configure  Webhook Gateway Project 

## configure application.properties

## Setup Database for webhook microservice ( MySql Database  Configuration )
<code>
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/webhook_microservice
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql: true
</code>

## Apache Kafka Configuration for Producure and Consume in application.properties

<code>
spring.kafka.consumer.bootstrap-servers: localhost:9092
spring.kafka.consumer.group-id: webhook_paymentkafka_payment
spring.kafka.consumer.auto-offset-reset: earliest
spring.kafka.consumer.key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer: org.apache.kafka.common.serialization.StringDeserializer


spring.kafka.producer.bootstrap-servers: localhost:9092
spring.kafka.producer.key-serializer: org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer: org.apache.kafka.common.serialization.StringSerializer

</code>

## API URL: <code>http://localhost:8081/publish</code>
Body Post Request:
<code>
{
  "eventName" : "Hello Japan vs Bangladesh VS Korea VS India ",
  "status": "Success"
}
</code>
Done, 

## In the console you will see the message send and receive message. Check two console where the project is running.

Thanks


