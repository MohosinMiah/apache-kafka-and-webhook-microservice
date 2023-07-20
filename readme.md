## How to Install

## First run docker in your local machine

<code>docker compose up -d</code>

<small> This command will run Apache Kafka as in the root we configure Dockerfile for Kafka run in Docker </small>

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


