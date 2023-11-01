package com.academy.airline.service;

import com.academy.airline.dto.FlightDto;
import java.util.List;

public interface FlightService {
    List<FlightDto> getFlights(String departureTime, String arrivalTime);
}
