package com.academy.airline.model.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "airplane_type")
public class AirplaneType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "first_class_seats")
    Integer firstClassSeats;
    @Column(name = "economy_class_seats")
    Integer economyClassSeats;
    @Column(name = "carrying_weight")
    Integer carryingWeight;
    @Column(name = "service_period")
    Integer servicePeriod;
}
