package com.kafka.producer.service;

import com.kafka.producer.domain.Booking;
import com.kafka.producer.model.FlightBookingRequest;

import java.util.List;


public interface IBookingService {

    Booking bookAFlight(final FlightBookingRequest bookingRequest);

    List<Booking> getAllBookings();

    Booking deleteBooking(final String refId);

}
