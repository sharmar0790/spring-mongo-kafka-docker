package com.kafka.producer.service;

public interface IFlightBookingProducer {

    void sendMessage(final String message, final String topicName);
}
