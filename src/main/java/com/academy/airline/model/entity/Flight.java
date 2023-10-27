package com.academy.airline.model.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigInteger id;
    @ManyToOne
    @JoinColumn(name = "route_id")
    Route route;
    @ManyToOne
    @JoinColumn(name = "airplane_id")
    Airplane airplane;
    @Column(name = "departure_time")
    Timestamp departureTime;
    @Column(name = "arrival_time")
    Timestamp arrivalTime;
    @ManyToOne
    @JoinColumn(name = "departure_gate")
    Gate departureGate;
    @ManyToOne
    @JoinColumn(name = "arrival_gate")
    Gate arrivalGate;
    @ManyToOne
    @JoinColumn(name = "status_id")
    FlightStatus status;
}
