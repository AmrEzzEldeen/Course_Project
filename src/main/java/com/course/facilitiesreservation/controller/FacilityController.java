package com.course.facilitiesreservation.controller;

import com.course.facilitiesreservation.entity.Facilitiy;
import com.course.facilitiesreservation.service.FacilitiyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    public ResponseEntity<List<Facilitiy>> getFacilities() {
        return ResponseEntity.ok(facilitiyService.getFacilities());
    }

    @PostMapping
    public ResponseEntity<Facilitiy> addFacility(@RequestBody Facilitiy facilitiy) {
        return new ResponseEntity<>(facilitiyService.addFacility(facilitiy), HttpStatus.CREATED);
    }
}
