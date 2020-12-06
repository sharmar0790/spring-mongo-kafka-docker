package com.kafka.producer.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FlightBookingRequest {

    private String name;
    private Integer age;
    private String gender;
    private String email;
    private String referenceId;
}
