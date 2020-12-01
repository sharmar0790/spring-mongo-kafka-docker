package com.kafka.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.kafka.producer.repository")
public class KafkaProducerFlightBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerFlightBookingApplication.class, args);
    }

}
