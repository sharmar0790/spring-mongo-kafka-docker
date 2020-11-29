package com.kafka.producer.model;

import com.kafka.producer.domain.Booking;

public class RemovedBookingMessage {

    private String referenceId;
    private String operation;
    private String email;
    private String name;

    public RemovedBookingMessage(Booking booking, final String operation) {
        this.referenceId = booking.getReferenceId();
        this.operation = operation;
        this.email = booking.getEmail();
        this.name = booking.getName();
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
