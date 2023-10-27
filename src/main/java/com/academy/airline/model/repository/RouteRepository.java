package com.academy.airline.model.repository;

import com.academy.airline.model.entity.Airport;
import com.academy.airline.model.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RouteRepository extends JpaRepository<Route, Integer> {
    List<Route> getByDepartureAirport(Airport departureAirport);
    List<Route> getByArrivalAirport(Airport arrivalAirport);
    Route getOneByDepartureAirportAndArrivalAirport(Airport departureAirport, Airport arrivalAirport);
}
