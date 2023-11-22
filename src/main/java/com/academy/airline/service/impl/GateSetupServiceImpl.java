package com.academy.airline.service.impl;

import org.springframework.stereotype.Service;

import com.academy.airline.dto.GatesDto;
import com.academy.airline.model.entity.Airport;
import com.academy.airline.model.entity.Flight;
import com.academy.airline.model.repository.FlightRepository;
import com.academy.airline.service.GateSetupService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GateSetupServiceImpl implements GateSetupService{
    private final FlightRepository flightRepository;

    @Override
    public void updateGates(GatesDto gatesInfo) {
        Flight flight = flightRepository.getReferenceById(gatesInfo.getFlightId());
        Airport airport;
        if (gatesInfo.getDepartureGate() != null) {
            airport = flight.getRoute().getDepartureAirport();
            airport.getGates().forEach((gate) -> {
                if (gate.getName().equals(gatesInfo.getDepartureGate())) {
                    flight.setDepartureGate(gate);
                    return;
                }
            });
        }
        if (gatesInfo.getArrivalGate() != null) {
            airport = flight.getRoute().getArrivalAirport();
            airport.getGates().forEach((gate) -> {
                if (gate.getName().equals(gatesInfo.getArrivalGate())) {
                    flight.setArrivalGate(gate);
                    return;
                }
            });
        }
        flightRepository.save(flight);
    }
    
}
