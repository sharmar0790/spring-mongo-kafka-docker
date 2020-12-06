package com.kafka.producer.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;



//@Entity
//@Table(name = "bookings")
@Document(collection = "bookings")
@Data
public class Booking {

    @Transient
    public static final String SEQIENCE_NAME="BOOKING_SEQUENCE";

    @Id
//    @GeneratedValue
    private Long id;

//    @Column(name = "name")
    private String name;

//    @Column(name = "age")
    private Integer age;

//    @Column(name = "gender")
    private String gender;

//    @Column(name = "email")
    private String email;

//    @Column(name = "reference_id")
    private String referenceId;

}
