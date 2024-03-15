package com.course.facilitiesreservation.dto.mapping;

import com.course.facilitiesreservation.dto.TenantDTO;
import com.course.facilitiesreservation.dto.UnitDTO;
import com.course.facilitiesreservation.entity.Tenant;
import com.course.facilitiesreservation.entity.Unit;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UnitMapper {
    private final TenantMapper tenantMapper;

    public UnitMapper(TenantMapper tenantMapper) {
        this.tenantMapper = tenantMapper;
    }

    public UnitDTO toUnitDTO (Unit unit) {
        UnitDTO unitDTO = new UnitDTO();
        unitDTO.setUnitNumber(unit.getUnitNumber());
        unitDTO.setUnitType(unit.getUnitType());
        unitDTO.setLocation(unit.getLocation());
        List<Tenant> tenants = unit.getTenants();
        List<TenantDTO> tenantDTOS = new ArrayList<>();
        for (Tenant tenant : tenants) {
            TenantDTO tenantDTO = tenantMapper.toTenantDto(tenant);
            tenantDTOS.add(tenantDTO);
        }
        unitDTO.setTenantDTOS(tenantDTOS);

        return unitDTO;
    }
}
