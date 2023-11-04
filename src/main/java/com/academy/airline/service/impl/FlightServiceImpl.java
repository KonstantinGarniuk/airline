package com.academy.airline.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.academy.airline.mapper.FlightMapper;
import com.academy.airline.model.entity.Flight;
import org.springframework.stereotype.Service;

import com.academy.airline.dto.FlightDto;
import com.academy.airline.model.repository.FlightRepository;
import com.academy.airline.service.FlightService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
	private final FlightRepository flightRepository;

	@Override
	public List<FlightDto> getFlights(LocalDateTime from, LocalDateTime to) {

		List<Flight> flights = flightRepository.findByArrivalTimeAfterAndDepartureTimeBefore(from, to);
		List<FlightDto> flightDtos = new ArrayList<>();

		flights.forEach(flight -> { flightDtos.add(FlightMapper.mapToFlightDto(flight)); });

		return flightDtos;
	}
	
}
