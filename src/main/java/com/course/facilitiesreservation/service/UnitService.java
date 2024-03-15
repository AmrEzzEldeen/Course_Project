package com.course.facilitiesreservation.service;

import com.course.facilitiesreservation.dto.TenantDTO;
import com.course.facilitiesreservation.dto.UnitDTO;
import com.course.facilitiesreservation.dto.mapping.TenantMapper;
import com.course.facilitiesreservation.dto.mapping.UnitMapper;
import com.course.facilitiesreservation.entity.Tenant;
import com.course.facilitiesreservation.entity.Unit;
import com.course.facilitiesreservation.repository.UnitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
@Service
public class UnitService {
    private final UnitRepository unitRepository;
    private final TenantMapper tenantMapper;
    private final UnitMapper unitMapper;

    public UnitService(UnitRepository unitRepository, TenantMapper tenantMapper, UnitMapper unitMapper) {
        this.unitRepository = unitRepository;
        this.tenantMapper = tenantMapper;
        this.unitMapper = unitMapper;
    }

    public List<UnitDTO> getAllUnits() {
        List<Unit> units = unitRepository.findAll();
        List<UnitDTO> unitDTOS = new ArrayList<>();
        for (Unit unit : units) {
            unitDTOS.add(unitMapper.toUnitDTO(unit));
        }
        return unitDTOS;
    }

    public ResponseEntity<Unit> addUnit( Unit unit) {
        Unit savedUnit = unitRepository.save(unit);
        return new ResponseEntity<>(savedUnit, HttpStatus.CREATED);
    }
}
