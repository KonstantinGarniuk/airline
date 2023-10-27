package com.academy.airline.service;

import com.academy.airline.model.entity.Airport;
import com.academy.airline.model.entity.Route;
import com.academy.airline.model.repository.RouteRepository;

import java.util.List;

public interface RouteService extends DefaultService<Route, Integer> {
    List<Route> getByDepartureAirport(Airport airport);
    List<Route> getByArrivalAirport(Airport airport);
    Route getRoute(Airport departure, Airport arrival);
}
