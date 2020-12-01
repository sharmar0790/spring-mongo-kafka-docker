package com.kafka.producer.resource;

import com.kafka.producer.domain.Booking;
import com.kafka.producer.model.FlightBookingRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//https://localhost:8081/api/
public interface IFlightBookingController {

    @GetMapping("/")
    String imHealthy();

    @PostMapping("/book-flight")
    String bookFlight(@RequestBody final FlightBookingRequest flightBookingRequest);

    @GetMapping("/bookings")
    @ResponseBody
    List<Booking> bookings();

    @DeleteMapping("/delete-booking/{bookingReferenceId}")
    @ResponseBody
    String deleteBooking(@PathVariable("bookingReferenceId") final String bookingReferenceId) throws Exception;
}
