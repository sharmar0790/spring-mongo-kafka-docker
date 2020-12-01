package com.kafka.producer.resource.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.producer.domain.Booking;
import com.kafka.producer.model.FlightBookingRequest;
import com.kafka.producer.model.RemovedBookingMessage;
import com.kafka.producer.resource.IFlightBookingController;
import com.kafka.producer.service.impl.BookingService;
import com.kafka.producer.service.impl.FlightBookingProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class FlightBookingController implements IFlightBookingController {

    private static final Logger LOG = LoggerFactory.getLogger(FlightBookingController.class);
    private static final String BLANK = "";
    private static final String BOOKING = "BOOKED";
    private static final String REMOVED = "REMOVED";
    private final static ObjectMapper obj = new ObjectMapper();
    private static String BOOKING_TOPIC = "booking";
    private static String REMOVED_TOPIC = "removed_topic";

    @Autowired
    BookingService bookingService;

    @Autowired
    FlightBookingProducer flightBookingProducer;


    public String imHealthy() {
        return "{\"healthy\": true}";
    }

    public String bookFlight(@RequestBody final FlightBookingRequest flightBookingRequest) {

        final Booking booking = bookingService.bookAFlight(flightBookingRequest);

        final String response = "{\"Booking ID\": \"" + booking.getReferenceId() + "\"}";

        flightBookingRequest.setReferenceId(booking.getReferenceId());
        sendMesage(booking, BOOKING);
        return response;
    }

    private void sendMesage(final Booking booking, final String operation) {
        String jsonStr = BLANK;
        try {
            jsonStr = obj.writeValueAsString(booking);
            Map<String, String> map = (Map<String, String>) obj.readValue(jsonStr, Map.class);
            map.put("operation", operation);
            jsonStr = obj.writeValueAsString(map);
            LOG.info("json converted request is {} ", jsonStr);
            flightBookingProducer.sendMessage(jsonStr, BOOKING_TOPIC);
        } catch (Exception e) {
            LOG.error("Caught error while converting object to JSON {}, error {}", booking, e);
            e.printStackTrace();
        }
    }

    public List<Booking> bookings() {
        return bookingService.getAllBookings();
    }


    public String deleteBooking(@PathVariable("bookingReferenceId") final String bookingReferenceId) throws Exception {
        String jsonStr = BLANK;
        final Booking booking = bookingService.deleteBooking(bookingReferenceId);
        if (null != booking) {
            final RemovedBookingMessage removedBookingMessage = new RemovedBookingMessage(booking, REMOVED);
            jsonStr = obj.writeValueAsString(removedBookingMessage);
            LOG.info("json converted request is {} ", jsonStr);
            flightBookingProducer.sendMessage(jsonStr, REMOVED_TOPIC);
            return jsonStr;
        } else {
            return "{\"Something went wrong while removing the booking\"}";
        }
    }
}
