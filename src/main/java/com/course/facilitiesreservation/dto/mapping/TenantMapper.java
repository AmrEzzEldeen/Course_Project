package com.course.facilitiesreservation.dto.mapping;

import com.course.facilitiesreservation.dto.TenantDTO;
import com.course.facilitiesreservation.entity.Tenant;
import org.springframework.stereotype.Component;

@Component
public class TenantMapper {
    public TenantDTO toTenantDto (Tenant tenant) {
        TenantDTO tenantDTO = new TenantDTO();
        tenantDTO.setFirstName(tenant.getFirstName());
        tenantDTO.setLastName(tenant.getLastName());
        tenantDTO.setGender(tenant.getGender());
        tenantDTO.setEmail(tenant.getEmail());
        tenantDTO.setUnitId(tenant.getUnit().getId());
        tenantDTO.setPhone(tenant.getPhone());
        return tenantDTO;
    }
}
