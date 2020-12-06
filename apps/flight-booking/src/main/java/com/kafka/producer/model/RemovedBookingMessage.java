package com.kafka.producer.model;

import com.kafka.producer.domain.Booking;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RemovedBookingMessage {

    private String referenceId;
    private String operation;
    private String email;
    private String name;

    public RemovedBookingMessage(final Booking booking, final String operation) {
        this.referenceId = booking.getReferenceId();
        this.operation = operation;
        this.email = booking.getEmail();
        this.name = booking.getName();
    }
}
