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
    private Integer id;
    @Column(name = "first_class_seats")
    private Integer firstClassSeats;
    @Column(name = "economy_class_seats")
    private Integer economyClassSeats;
    @Column(name = "carrying_weight")
    private Integer carryingWeight;
    @Column(name = "service_period")
    private Integer servicePeriod;
}
