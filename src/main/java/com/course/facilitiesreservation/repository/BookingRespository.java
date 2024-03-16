package com.course.facilitiesreservation.repository;

import com.course.facilitiesreservation.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Book;
import java.util.List;

public interface BookingRespository extends JpaRepository<Booking, Long> {
    @Query("SELECT b FROM Booking b WHERE b.timeSlot.facility.id = :facilityId")
    List<Booking> findAllByFacilityId(@Param("facilityId") Long facilityId);
}
