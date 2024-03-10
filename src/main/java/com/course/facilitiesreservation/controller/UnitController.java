package com.course.facilitiesreservation.controller;

import com.course.facilitiesreservation.entity.Unit;
import com.course.facilitiesreservation.service.UnitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/units")
public class UnitController {
    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping
    public ResponseEntity<List<Unit>> getAllUnits() {
        return unitService.getAllUnits();
    }

    @PostMapping
    public ResponseEntity<Unit> addUnit(@RequestBody Unit unit) {
        return unitService.addUnit(unit);
    }
}
