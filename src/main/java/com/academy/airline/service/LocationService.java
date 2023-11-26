package com.academy.airline.service;

import java.util.Set;

public interface LocationService {
    
    Set<String> getDepartureLocations(String destinationLocationName);
    Set<String> getDestinationLocations(String departureLocationName);
}
