package com.course.facilitiesreservation.dto;

import com.course.facilitiesreservation.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TenantDTO {
//    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Gender gender;
    private Long unitId;
}
