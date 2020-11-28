package com.kafka.producer.repository;

import com.kafka.producer.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("select b from Booking b where b.referenceId=:refId")
    Booking findByRefId(final String refId);
}
