package com.academy.airline.service;

import com.academy.airline.model.entity.Location;
import com.academy.airline.model.repository.LocationRepository;

import java.util.List;

public interface LocationService extends DefaultService<Location, Integer>{
    List<Location> getByCountry(String country);
}
