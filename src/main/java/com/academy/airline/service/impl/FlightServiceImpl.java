package com.academy.airline.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.academy.airline.mapper.FlightMapper;
import com.academy.airline.model.entity.Airplane;
import com.academy.airline.model.entity.Airport;
import com.academy.airline.model.entity.Flight;
import com.academy.airline.model.entity.FlightStatus;
import com.academy.airline.model.entity.Location;
import com.academy.airline.model.entity.converter.FlightStatusConverter;

import org.springframework.stereotype.Service;

import com.academy.airline.dto.ArrivalGateDto;
import com.academy.airline.dto.DepartureGateDto;
import com.academy.airline.dto.FlightDto;
import com.academy.airline.dto.FlightStatusDto;
import com.academy.airline.model.repository.AirplaneRepository;
import com.academy.airline.model.repository.FlightRepository;
import com.academy.airline.service.EmployeeService;
import com.academy.airline.service.FlightService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
	private final FlightRepository flightRepository;
	private final AirplaneRepository airplaneRepository;
	private final EmployeeService employeeService;

	@Override
	public List<FlightDto> getFlights(LocalDateTime from, LocalDateTime to) {

		List<Flight> flights = flightRepository.findByArrivalTimeAfterAndDepartureTimeBefore(from, to);
		List<FlightDto> flightDtos = new ArrayList<>();

		flights.forEach(flight -> flightDtos.add(FlightMapper.mapToFlightDto(flight)) );

		return flightDtos;
	}

	@Override
	public void updateDepartureGate(DepartureGateDto departure) {
		Flight flight = flightRepository.getReferenceById(departure.getFlightId());
        if (departure.getDepartureGate() != null) {
            Airport airport = flight.getRoute().getDepartureAirport();
            airport.getGates().forEach(gate -> {
                if (gate.getName().equals(departure.getDepartureGate())) {
                    flight.setDepartureGate(gate);
                    return;
                }
            });
			flightRepository.save(flight);
        }
	}

	@Override
	public void updateArrivalGate(ArrivalGateDto arrival) {
		Flight flight = flightRepository.getReferenceById(arrival.getFlightId());
		if (arrival.getArrivalGate() != null) {
            Airport airport = flight.getRoute().getArrivalAirport();
            airport.getGates().forEach(gate -> {
                if (gate.getName().equals(arrival.getArrivalGate())) {
                    flight.setArrivalGate(gate);
                    return;
                }
            });
			flightRepository.save(flight);
        }
	}

	@Override
	public void updateStatus(FlightStatusDto status) {
		Flight flight = flightRepository.getReferenceById(status.getFlightId());
		if (status.getFlightStatus() != null) {
			FlightStatus flightStatus = new FlightStatusConverter().convertToEntityAttribute(status.getFlightStatus());
			flight.setStatus(flightStatus);
			if (flightStatus == FlightStatus.LANDED) {
				Location location = flight.getRoute().getArrivalAirport().getLocation();
				Airplane airplane = flight.getAirplane();
				airplane.setLocation(location);
				airplaneRepository.save(airplane);
				employeeService.updateLocation(airplane.getCrew(), location);
				
			}
			flightRepository.save(flight);
		}
	}
	
}
