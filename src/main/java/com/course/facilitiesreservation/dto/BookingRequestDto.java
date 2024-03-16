package com.course.facilitiesreservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Component
public class BookingRequestDto {
    private Long tenantId;
    private Long facilityTimeSlotId;
}
