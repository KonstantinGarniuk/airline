package com.academy.airline.service;

import com.academy.airline.dto.ArrivalGateDto;
import com.academy.airline.dto.DepartureGateDto;
import com.academy.airline.dto.FlightDto;
import com.academy.airline.dto.FlightStatusDto;
import com.academy.airline.dto.RouteRequestDto;
import com.academy.airline.dto.RouteResponseDto;
import com.academy.airline.model.entity.Account;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    List<FlightDto> getFlights(LocalDateTime from, LocalDateTime to);
    void updateDepartureGate(DepartureGateDto departure);
    void updateArrivalGate(ArrivalGateDto arrival);
    void updateStatus(FlightStatusDto status);
    
    List<RouteResponseDto> getDirectFlights(RouteRequestDto request, Account account);  
    List<RouteResponseDto> getReturnFlights(RouteRequestDto request, Account account);
    RouteResponseDto getFlight(BigInteger id, Account account);
}
