package com.academy.airline.service.impl;

import com.academy.airline.model.entity.Airport;
import com.academy.airline.model.entity.Location;
import com.academy.airline.model.entity.Route;
import com.academy.airline.model.repository.RouteRepository;
import com.academy.airline.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.function.BiConsumer;

@Service
public class RouteServiceImpl extends DefaultServiceImpl<Route, Integer> implements RouteService {
    private RouteRepository routeRepository;
    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository) {
        this.repository = routeRepository;
        this.routeRepository = routeRepository;
    }

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
