package com.academy.airline.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.airline.dto.FlightDto;
import com.academy.airline.model.repository.FlightRepository;
import com.academy.airline.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {
	private FlightRepository flightRepository;

	@Autowired
	public FlightServiceImpl(FlightRepository flightRepository) {
		this.flightRepository = flightRepository;
	}
	@Override
	public List<FlightDto> getFlights(String departureTime, String arrivalTime) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getFlights'");
	}
	
}
