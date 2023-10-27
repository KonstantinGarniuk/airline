package com.academy.airline.service.impl;

import com.academy.airline.model.entity.Airport;
import com.academy.airline.model.entity.Location;
import com.academy.airline.model.repository.AirportRepository;
import com.academy.airline.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportServiceImpl extends DefaultServiceImpl<Airport, Integer> implements AirportService {
    private AirportRepository airportRepository;
    @Autowired
    public AirportServiceImpl(AirportRepository airportRepository) {
        this.repository = airportRepository;
        this.airportRepository = airportRepository;
    }
    @Override
    public List<Airport> getByName(String name) {
        return airportRepository.findByName(name);
    }

    @Override
    public List<Airport> getByLocation(Location location) {
        return airportRepository.findByLocation(location);
    }
}
