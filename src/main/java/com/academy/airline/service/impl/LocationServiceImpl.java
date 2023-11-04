package com.academy.airline.service.impl;

import com.academy.airline.model.entity.Location;
import com.academy.airline.model.repository.LocationRepository;
import com.academy.airline.service.LocationService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl extends DefaultServiceImpl<Location, Integer> implements LocationService {
    private final LocationRepository locationRepository;
    

    @Override
    public List<Location> getByCountry(String country) {
        return locationRepository.getByCountry(country);
    }
}
