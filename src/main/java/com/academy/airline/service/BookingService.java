package com.academy.airline.service;

import java.util.List;

import com.academy.airline.dto.RouteRequestDto;
import com.academy.airline.model.entity.Flight;

public interface BookingService {
    List<String> getFromAirports(String airportName);
    List<String> getToAirports(String airportName);
    List<Flight> getResults(RouteRequestDto request);    
}
