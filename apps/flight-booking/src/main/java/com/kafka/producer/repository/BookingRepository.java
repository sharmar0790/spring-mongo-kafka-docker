package com.kafka.producer.repository;

import com.kafka.producer.domain.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
//public interface BookingRepository extends JpaRepository<Booking, Long> {
public interface BookingRepository extends MongoRepository<Booking, Long> {

//    @Query("select b from Booking b where b.referenceId=:refId")  ##JPA specific query
    @Query("{ 'referenceId' : ?0 }")  // Mongo specific query
    Booking findByRefId(final String refId);
}
