package com.kafka.producer.service.impl;

import com.kafka.producer.domain.Booking;
import com.kafka.producer.model.FlightBookingRequest;
import com.kafka.producer.repository.BookingRepository;
import com.kafka.producer.service.IBookingService;
import com.kafka.producer.sequencegenerator.SequenceGeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
public class BookingService implements IBookingService {

    private static final Logger LOG = LoggerFactory.getLogger(BookingService.class);
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy", Locale.ENGLISH);

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    public Booking bookAFlight(final FlightBookingRequest bookingRequest) {

        final Booking booking = new Booking();
        booking.setId(sequenceGeneratorService.generateSequence(Booking.SEQIENCE_NAME));
        booking.setAge(bookingRequest.getAge());
        booking.setGender(bookingRequest.getGender());
        booking.setName(bookingRequest.getName());
        booking.setEmail(bookingRequest.getEmail());

        LocalDateTime ldt = LocalDateTime.now();

        String referenceId = UUID.randomUUID().toString() + dtf.format(ldt);

        LOG.info("Ref ID : {}", referenceId);
        booking.setReferenceId(referenceId);
        bookingRepository.save(booking);

        return booking;
    }


    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking deleteBooking(String refId) {
        try {
            final Booking booking = bookingRepository.findByRefId(refId);
            bookingRepository.deleteById(booking.getId());
            return booking;
        } catch (Exception e) {
            LOG.error("Got error while deleting a booking : {}, id {}", refId, e);
            return null;
        }
    }
}
