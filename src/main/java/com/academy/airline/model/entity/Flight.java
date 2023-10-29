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
    private BigInteger id;
    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;
    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;
    @Column(name = "departure_time")
    private Timestamp departureTime;
    @Column(name = "arrival_time")
    private Timestamp arrivalTime;
    @ManyToOne
    @JoinColumn(name = "departure_gate")
    private Gate departureGate;
    @ManyToOne
    @JoinColumn(name = "arrival_gate")
    private Gate arrivalGate;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private FlightStatus status;
}
