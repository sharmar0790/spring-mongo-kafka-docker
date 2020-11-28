package com.kafka.consumer.model;

public class RemovedBookingMessage {

    private String referenceId;
    private String operation;
    private String email;
    private String name;

    public String getReferenceId() {
        return referenceId;
    }

    public String getOperation() {
        return operation;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
