package com.course.facilitiesreservation.controller;

import com.course.facilitiesreservation.entity.TimeSlot;
import com.course.facilitiesreservation.service.TimeSlotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timeslots")
public class TimeSlotController {
    private final TimeSlotService timeSlotService;

    public TimeSlotController(TimeSlotService timeSlotService) {
        this.timeSlotService = timeSlotService;
    }

    @GetMapping("/{facilityid}")
    public List<TimeSlot> getTimeSlotsForFacility(@PathVariable Long facilityid) {
        return timeSlotService.getTimeSlotsForFacility(facilityid);
    }

    @PostMapping("/{facilityid}")
    public TimeSlot addTimeSlot(@RequestBody TimeSlot timeSlot, @PathVariable Long facilityid) {
        return timeSlotService.addTimeSlot(timeSlot, facilityid);
    }

    @DeleteMapping("/{facilityid}")
    public ResponseEntity<String> deleteTimeSlotsForFacility (@PathVariable Long facilityid) {
        timeSlotService.deleteTimeSlotsForFacility(facilityid);
        return new ResponseEntity<>("Facility Deleted", HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/timeslot/{timeslotId}")
    public String deleteTimeSlot (@PathVariable Long timeslotId) {
        timeSlotService.deleteTimeSlot(timeslotId);
        return "Time slot deleted successfully";
    }
}
