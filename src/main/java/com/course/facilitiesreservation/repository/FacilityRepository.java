package com.course.facilitiesreservation.repository;

import com.course.facilitiesreservation.entity.Facilitiy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository extends JpaRepository<Facilitiy, Long> {

}
