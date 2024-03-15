package com.course.facilitiesreservation.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "time_slots")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;

    @Column(name = "start_hour", nullable = false)
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startHour;

    @Column(name = "end_hour", nullable = false)
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime endHour;

    @ManyToOne
    @JoinColumn(name = "facility_id", nullable = false)
    private Facility facility;

    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable;
}
