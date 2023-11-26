package com.academy.airline.service.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.academy.airline.model.entity.Location;
import com.academy.airline.model.entity.Route;
import com.academy.airline.model.repository.LocationRepository;
import com.academy.airline.model.repository.RouteRepository;
import com.academy.airline.service.LocationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService{
    private final LocationRepository locationRepository;
    private final RouteRepository routeRepository;

    @Override
    public Set<String> getDepartureLocations(String destinationLocationName) {
        Set<String> departureLocationNames = new LinkedHashSet<>();
        if (destinationLocationName == null) {
            List<Location> departureLocation = locationRepository.findAll();
            departureLocation.forEach(airport -> departureLocationNames.add(airport.getTown()));
        } else {
            List<Location> locations = locationRepository.findByTown(destinationLocationName);
            locations.forEach(location -> {
                List<Route> routes = routeRepository.findByDestinationLocation(location);
                routes.forEach(route -> departureLocationNames.add(route.getDepartureAirport().getLocation().getTown()));
            });
        }
        return departureLocationNames;
    }

    @Override
    public Set<String> getDestinationLocations(String departureLocationName) {
        Set<String> destinationLocationNames = new LinkedHashSet<>();
        List<Location> locations;
        if (departureLocationName == null) {
            locations = locationRepository.findAll();
            locations.forEach(airport -> destinationLocationNames.add(airport.getTown()));
        } else {
            locations = locationRepository.findByTown(departureLocationName);
            locations.forEach(location -> {
                List<Route> routes = routeRepository.findByDepartureLocation(location);
                routes.forEach(route -> destinationLocationNames.add(route.getDestinationAirport().getLocation().getTown()));
            });
            
        }
        return destinationLocationNames;
    }
}
