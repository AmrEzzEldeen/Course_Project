package com.course.facilitiesreservation.service;

import com.course.facilitiesreservation.entity.Facilitiy;
import com.course.facilitiesreservation.repository.FacilityRepository;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public class FacilitiyService {
    private final FacilityRepository facilityRepository;

    public FacilitiyService(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    public List<Facilitiy> getFacilities() {
        return facilityRepository.findAll();
    }


    public Facilitiy addFacility(Facilitiy facilitiy) {
        return facilityRepository.save(facilitiy);
    }
}
