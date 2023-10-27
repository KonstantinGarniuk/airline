package com.academy.airline.service;

import com.academy.airline.model.entity.Flight;
import com.academy.airline.model.entity.FlightStatus;
import com.academy.airline.model.entity.Gate;
import com.academy.airline.model.entity.Route;
import com.academy.airline.model.repository.FlightRepository;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public interface FlightService extends DefaultService<Flight, BigInteger> {
    List<Flight> getByRoute(Route route);
    List<Flight> getByDepartureTime(Timestamp time);
    List<Flight> getByArrivalTime(Timestamp time);
    List<Flight> getAvailable(Route route, LocalDate date);
    FlightStatus getStatus(Route route);
    boolean setStatus(Route route, FlightStatus status);
    Gate getDepartureGate(Route route);
    boolean setDepartureGate(Route route, Gate gate);
    Gate getArrivalGate(Route route);
    boolean setArrivalGate(Route route, Gate gate);
}
