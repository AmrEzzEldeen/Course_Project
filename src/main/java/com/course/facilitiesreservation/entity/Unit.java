package com.course.facilitiesreservation.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "units")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unit_number", nullable = false)
    private String unitNumber;

    @Column(name = "unit_type", nullable = false)
    private String unitType;

    @Column(nullable = false)
    private String location;

    @OneToMany(mappedBy = "unit")
//    @JsonManagedReference
    private List<Tenant> tenants;

}
