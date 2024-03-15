package com.course.facilitiesreservation.service;

import com.course.facilitiesreservation.dto.TenantDTO;
import com.course.facilitiesreservation.dto.mapping.TenantMapper;
import com.course.facilitiesreservation.entity.Tenant;
import com.course.facilitiesreservation.entity.Unit;
import com.course.facilitiesreservation.repository.TenantRepository;
import com.course.facilitiesreservation.repository.UnitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TenantService {
    private final TenantRepository tenantRepository;
    private final UnitRepository unitRepository;

    private final TenantMapper tenantMapper;

    public TenantService(TenantRepository tenantRepository, UnitRepository unitRepository, TenantMapper tenantMapper) {

        this.tenantRepository = tenantRepository;
        this.unitRepository = unitRepository;
        this.tenantMapper = tenantMapper;
    }

    public TenantDTO createTenant(Tenant tenant, Long unitId) {
        Unit unit = unitRepository.findById(unitId)
                .orElseThrow(() -> new RuntimeException("Unit not found"));
        System.out.println("UNIT IS FOUND");
        tenant.setUnit(unit);
        tenantRepository.save(tenant);

        return tenantMapper.toTenantDto(tenant);
    }

    public ResponseEntity<List<TenantDTO>> getAllTenants() {
        List<Tenant> tenants = tenantRepository.findAll();
        List<TenantDTO> tenantDTOS = new ArrayList<>();
        for (Tenant tenant : tenants) {
            tenantDTOS.add(tenantMapper.toTenantDto(tenant));
        }
        return new ResponseEntity<>(tenantDTOS, HttpStatus.OK);
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

    public List<TenantDTO> getTenantsByUserName(String userName) {
       List<Tenant> tenants =tenantRepository.findByFirstNameContainingIgnoreCase(userName);
       List<TenantDTO> tenantDTOS = new ArrayList<>();
        for (Tenant tenant : tenants) {
            tenantDTOS.add(tenantMapper.toTenantDto(tenant));
        }
        return tenantDTOS;
    }
}
