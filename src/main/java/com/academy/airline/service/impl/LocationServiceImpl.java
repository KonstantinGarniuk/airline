package com.academy.airline.service.impl;

import com.academy.airline.model.entity.Location;
import com.academy.airline.model.repository.LocationRepository;
import com.academy.airline.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl extends DefaultServiceImpl<Location, Integer> implements LocationService {
    private LocationRepository locationRepository;
    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.repository = locationRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> getByCountry(String country) {
        return locationRepository.getByCountry(country);
    }
}
