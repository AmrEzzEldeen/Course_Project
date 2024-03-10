package com.course.facilitiesreservation.repository;

import com.course.facilitiesreservation.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant,Long> {
}
