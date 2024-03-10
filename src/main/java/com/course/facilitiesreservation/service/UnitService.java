package com.course.facilitiesreservation.service;

import com.course.facilitiesreservation.entity.Unit;
import com.course.facilitiesreservation.repository.UnitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class UnitService {
    private final UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public ResponseEntity<List<Unit>> getAllUnits() {
        return new ResponseEntity<>(unitRepository.findAll(), HttpStatus.FOUND);
    }

    public ResponseEntity<Unit> addUnit( Unit unit) {
        Unit savedUnit = unitRepository.save(unit);
        return new ResponseEntity<>(savedUnit, HttpStatus.CREATED);
    }
}
