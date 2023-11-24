package com.academy.airline.service;

import com.academy.airline.dto.ArrivalGateDto;
import com.academy.airline.dto.DepartureGateDto;
import com.academy.airline.dto.FlightDto;
import com.academy.airline.dto.FlightStatusDto;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    List<FlightDto> getFlights(LocalDateTime from, LocalDateTime to);
    void updateDepartureGate(DepartureGateDto departure);
    void updateArrivalGate(ArrivalGateDto arrival);
    void updateStatus(FlightStatusDto status);
}
