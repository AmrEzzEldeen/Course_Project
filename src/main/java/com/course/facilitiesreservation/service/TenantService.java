package com.course.facilitiesreservation.service;

import com.course.facilitiesreservation.entity.Tenant;
import com.course.facilitiesreservation.entity.Unit;
import com.course.facilitiesreservation.repository.TenantRepository;
import com.course.facilitiesreservation.repository.UnitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantService {
    private final TenantRepository tenantRepository;
    private final UnitRepository unitRepository;

    public TenantService(TenantRepository tenantRepository, UnitRepository unitRepository) {

        this.tenantRepository = tenantRepository;
        this.unitRepository = unitRepository;
    }

    public Tenant createTenant(Tenant tenant, Long unitId) {
        Unit unit = unitRepository.findById(unitId)
                .orElseThrow(() -> new RuntimeException("Unit not found"));
        System.out.println("UNIT IS FOUND");
        tenant.setUnit(unit);
        return tenantRepository.save(tenant);
    }

    public ResponseEntity<List<Tenant>> getAllTenants() {
        return new ResponseEntity<>(tenantRepository.findAll(), HttpStatus.OK);
    }

    public void deleteTenantById(Long id) {
        tenantRepository.deleteById(id);
    }

    public Tenant updateById( Long tenantID, Tenant updatedTenant,  Long unitId) {
        Unit unit = unitRepository.findById(unitId)
                .orElseThrow(() -> new RuntimeException("Unit not found"));
        return tenantRepository.findById(tenantID)
                .map(tenant -> {
                    tenant.setFirstName(updatedTenant.getFirstName());
                    tenant.setLastName(updatedTenant.getLastName());
                    tenant.setUnit(unit);
                    tenant.setEmail(updatedTenant.getEmail());
                    tenant.setPhone(updatedTenant.getPhone());
                    tenant.setDateOfBirth(updatedTenant.getDateOfBirth());
                    return tenantRepository.save(tenant);
                })
                .orElseThrow(() -> new RuntimeException("Tenant not found with id " + tenantID));
    }

    public List<Tenant> getTenantsByUserName(String userName) {
        return tenantRepository.findByFirstNameContainingIgnoreCase(userName);
    }
}
