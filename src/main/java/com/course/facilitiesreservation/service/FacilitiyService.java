package com.course.facilitiesreservation.service;

import com.course.facilitiesreservation.entity.Facility;
import com.course.facilitiesreservation.repository.FacilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilitiyService {
    private final FacilityRepository facilityRepository;

    public FacilitiyService(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    public List<Facility> getFacilities() {
        return facilityRepository.findAll();
    }


    public Facility addFacility(Facility facility) {
        return facilityRepository.save(facility);
    }

    public Facility getFacilityById(Long facilityId) {
        return facilityRepository.findById(facilityId)
                .orElseThrow(() -> new RuntimeException("No facility found"));
    }
}
