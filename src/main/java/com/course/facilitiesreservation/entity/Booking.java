package com.course.facilitiesreservation.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenant_id", nullable = false)
    private Long tenantId;

    @Column(name = "facility_time_slot_id", nullable = false, unique = true)
    private Long facilityTimeSlotId;

    @Column(name = "booking_date", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate bookingDate;

    @ManyToOne
    @JoinColumn(name = "tenant_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonBackReference
    private Tenant tenant;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "facility_time_slot_id", referencedColumnName = "id", insertable = false, updatable = false)
    private TimeSlot timeSlot;
}