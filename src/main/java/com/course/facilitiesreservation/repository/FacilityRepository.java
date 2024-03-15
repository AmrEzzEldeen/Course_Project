package com.course.facilitiesreservation.repository;

import com.course.facilitiesreservation.entity.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository extends JpaRepository<Facility, Long> {

}
