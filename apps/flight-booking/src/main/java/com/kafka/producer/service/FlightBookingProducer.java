package com.kafka.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@ConfigurationProperties(prefix = "flight-booking")
public class FlightBookingProducer {

    private static final Logger LOG = LoggerFactory.getLogger(FlightBookingProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(final String message,final String topicName) {
        LOG.info(String.format("##### -> Producing to topic -> %s message -> %s", topicName, message));
        ListenableFuture<SendResult<String, String>> future = this.kafkaTemplate.send(topicName, message);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                LOG.error("Unable to deliver message [{}]. {}",
                        message,
                        ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                LOG.info("Message [{}] delivered with offset {}",
                        message,
                        result.getRecordMetadata().offset());
            }
        });

        this.kafkaTemplate.flush();
    }
}
