package com.course.facilitiesreservation.dto;

import com.course.facilitiesreservation.entity.Tenant;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UnitDTO {
    private String unitNumber;

    private String unitType;

    private String location;

    private List<TenantDTO> tenantDTOS;
}
