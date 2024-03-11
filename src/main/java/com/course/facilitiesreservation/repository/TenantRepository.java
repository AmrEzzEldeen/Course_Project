package com.course.facilitiesreservation.repository;

import com.course.facilitiesreservation.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TenantRepository extends JpaRepository<Tenant,Long> {
    List<Tenant> findByFirstNameContainingIgnoreCase(String name);
}
