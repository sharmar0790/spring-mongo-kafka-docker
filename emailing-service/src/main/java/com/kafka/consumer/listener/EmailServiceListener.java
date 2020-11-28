package com.kafka.consumer.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.consumer.model.BookingRequest;
import com.kafka.consumer.model.RemovedBookingMessage;
import com.kafka.consumer.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceListener {

    private final Logger LOG = LoggerFactory.getLogger(EmailServiceListener.class);

    @Autowired
    EmailService emailService;

    private static ObjectMapper obj = new ObjectMapper();

    @KafkaListener(topics = "${topic.flight-booking}", groupId = "${spring.kafka.consumer.group-id}")
    //@KafkaListener(topics = "booking", groupId = "email_id")
    public void consumeBookedMessage(final String record) throws Exception {
        LOG.info("#### -> received message -> {}", record);
        final BookingRequest br = obj.readValue(record, BookingRequest.class);
        LOG.info("#### -> booking request message -> {}", br);
        emailService.sendEmail(br);
    }

    @KafkaListener(topics = "${topic.removed-booking}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeRemovedBookingMessage(final String record) throws Exception {
        LOG.info("#### -> received message -> {}", record);
        final RemovedBookingMessage msg = obj.readValue(record, RemovedBookingMessage.class);
        LOG.info("#### -> booking request message -> {}", msg);
        emailService.sendEmail(msg);
    }
}
