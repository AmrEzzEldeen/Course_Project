package com.course.facilitiesreservation.service;

import com.course.facilitiesreservation.entity.Facility;
import com.course.facilitiesreservation.entity.TimeSlot;
import com.course.facilitiesreservation.repository.FacilityRepository;
import com.course.facilitiesreservation.repository.TimeSlotRespository;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TimeSlotService {
    private final TimeSlotRespository timeSlotRepository;
    private final FacilityRepository facilityRepository;
    private final FacilitiyService facilitiyService;

    public TimeSlotService(TimeSlotRespository timeSlotRespository, FacilityRepository facilityRepository, FacilitiyService facilitiyService) {
        this.timeSlotRepository = timeSlotRespository;
        this.facilityRepository = facilityRepository;
        this.facilitiyService = facilitiyService;
    }

    public List<TimeSlot> getTimeSlotsForFacility(Long facilityId) {
        return timeSlotRepository.findAll().stream()
                .filter(timeSlot -> timeSlot.getFacility().getId().equals(facilityId))
                .collect(Collectors.toList());
    }

    public TimeSlot addTimeSlot(TimeSlot timeSlot, Long facilityId) {
        Facility facility = facilitiyService.getFacilityById(facilityId);

        // Check if a TimeSlot with the same start date and start hour already exists
        List<TimeSlot> existingTimeSlots = timeSlotRepository.findByStartDateAndStartHour(timeSlot.getStartDate(), timeSlot.getStartHour());
        if (!existingTimeSlots.isEmpty()) {
            throw new RuntimeException("A timeslot with the same start date and start hour already exists");
        }
        TimeSlot toBeSavedtimeSlot = new TimeSlot();
        toBeSavedtimeSlot.setStartDate(timeSlot.getStartDate());
        toBeSavedtimeSlot.setIsAvailable(true);
        toBeSavedtimeSlot.setStartHour(timeSlot.getStartHour());
        toBeSavedtimeSlot.setEndHour(timeSlot.getStartHour().plusHours(1)); // Add one hour to the start time
        toBeSavedtimeSlot.setFacility(facility);
        return timeSlotRepository.save(toBeSavedtimeSlot);
    }


    public String deleteTimeSlotsForFacility(Long facilityid) {
        Facility facility = facilityRepository.findById(facilityid)
                .orElseThrow(() -> new RuntimeException("No facility found with the given ID"));
        List<TimeSlot> timeSlots = timeSlotRepository.findByFacilityId(facilityid);
        timeSlotRepository.deleteAll(timeSlots);
        return "Deleted all time slots for facility with id: " + facilityid;
    }
}
