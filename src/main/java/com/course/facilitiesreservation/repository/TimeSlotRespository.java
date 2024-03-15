package com.course.facilitiesreservation.repository;

import com.course.facilitiesreservation.entity.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface TimeSlotRespository extends JpaRepository<TimeSlot, Long> {
    List<TimeSlot> findByStartDateAndStartHour(LocalDate startDate, LocalTime startHour);

    List<TimeSlot> findByFacilityId(Long facilityid);
}

