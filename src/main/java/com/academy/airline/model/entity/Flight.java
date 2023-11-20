package com.academy.airline.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

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
    private LocalDateTime departureTime;
    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;
    @ManyToOne
    @JoinColumn(name = "departure_gate_id")
    private Gate departureGate;
    @ManyToOne
    @JoinColumn(name = "arrival_gate_id")
    private Gate arrivalGate;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private FlightStatus status;
}
