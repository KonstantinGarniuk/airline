package com.academy.airline.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @Column(name = "job")
    @Enumerated(EnumType.STRING)
    private Job job;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    @Column(name = "salary")
    private Integer salary;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;
}
