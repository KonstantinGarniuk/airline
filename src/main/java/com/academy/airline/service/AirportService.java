package com.academy.airline.service;

import com.academy.airline.model.entity.Airport;
import com.academy.airline.model.entity.Location;

import java.util.List;

public interface AirportService extends DefaultService<Airport, Integer>{
    List<Airport> getByName(String name);
    List<Airport> getByLocation(Location location);
}
