package com.academy.airline.service;

import com.academy.airline.dto.FlightDto;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    List<FlightDto> getFlights(LocalDateTime from, LocalDateTime to);
}
