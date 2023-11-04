package com.academy.airline.service.impl;

import com.academy.airline.model.entity.Airport;
import com.academy.airline.model.entity.Location;
import com.academy.airline.model.repository.AirportRepository;
import com.academy.airline.service.AirportService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl extends DefaultServiceImpl<Airport, Integer> implements AirportService {
    private final AirportRepository airportRepository;

    @Override
    public List<Airport> getByName(String name) {
        return airportRepository.findByName(name);
    }

    @Override
    public List<Airport> getByLocation(Location location) {
        return airportRepository.findByLocation(location);
    }
}
