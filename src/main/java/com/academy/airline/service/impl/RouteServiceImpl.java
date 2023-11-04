package com.academy.airline.service.impl;

import com.academy.airline.model.entity.Airport;
import com.academy.airline.model.entity.Route;
import com.academy.airline.model.repository.RouteRepository;
import com.academy.airline.service.RouteService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl extends DefaultServiceImpl<Route, Integer> implements RouteService {
    private final RouteRepository routeRepository;

    @Override
    public List<Route> getByDepartureAirport(Airport airport) {
        return routeRepository.getByDepartureAirport(airport);
    }

    @Override
    public List<Route> getByArrivalAirport(Airport airport) {
        return routeRepository.getByArrivalAirport(airport);
    }

    @Override
    public Route getRoute(Airport departure, Airport arrival) {
        return routeRepository.getOneByDepartureAirportAndArrivalAirport(departure, arrival);
    }
}
