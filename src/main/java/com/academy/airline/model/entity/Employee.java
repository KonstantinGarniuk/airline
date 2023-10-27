package com.academy.airline.model.entity;

import javax.persistence.*;
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
    BigInteger id;
    @ManyToOne
    @JoinColumn(name = "person_id")
    Person person;
    @ManyToOne
    @JoinColumn(name = "job_id")
    Job job;
    @ManyToOne
    @JoinColumn(name = "location_id")
    Location location;
    @Column(name = "salary")
    Integer salary;
    @ManyToOne
    @JoinColumn(name = "status_id")
    EmployeeStatus status;
}
