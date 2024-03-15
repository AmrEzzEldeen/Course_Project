package com.course.facilitiesreservation.controller;

import com.course.facilitiesreservation.entity.Facility;
import com.course.facilitiesreservation.service.FacilitiyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facilities")
public class FacilityController {
    private final FacilitiyService facilitiyService;

    public FacilityController(FacilitiyService facilitiyService) {
        this.facilitiyService = facilitiyService;
    }

    @GetMapping
    public ResponseEntity<List<Facility>> getFacilities() {
        return ResponseEntity.ok(facilitiyService.getFacilities());
    }

    @GetMapping("/{facilityid}")
    public ResponseEntity<Facility> getFacilityById(@PathVariable Long facilityid) {
        return new ResponseEntity<>(facilitiyService.getFacilityById(facilityid), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Facility> addFacility(@RequestBody Facility facility) {
        return new ResponseEntity<>(facilitiyService.addFacility(facility), HttpStatus.CREATED);
    }
}
