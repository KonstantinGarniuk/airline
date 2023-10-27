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
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    Airport departureAirport;
    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    Airport arrivalAirport;
    @Column(name = "distance")
    Integer distance;
}
