package com.academy.airline.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import com.academy.airline.mapper.FlightMapper;
import com.academy.airline.model.entity.Flight;
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
	public List<FlightDto> getFlights(String from, String to) {

		LocalDateTime fromTime = LocalDate.now().atStartOfDay();
		if(from != null) {
			try {
				fromTime = LocalDate.parse(from).atStartOfDay();
			} catch (DateTimeParseException e) {
				System.out.println("Cannot parse 'from' time. Set to start of current day.");
			}
		} else {
			System.out.println("'From' time is null. Set to now.");
		}

		LocalDateTime toTime = fromTime.plusDays(1);
		if (to != null) {
			try {
				toTime = LocalDate.parse(to).atTime(23, 59);
			} catch (DateTimeParseException e) {
				System.out.println("Cannot parse 'to' time. Set one day after 'from'");
			}
		} else {
			System.out.println("'To' time is null. Set one day after 'from'");
		}

		List<Flight> flights = flightRepository.findByArrivalTimeAfterAndDepartureTimeBefore(fromTime, toTime);
		List<FlightDto> flightDtos = new ArrayList<>();

		flights.forEach(flight -> { flightDtos.add(FlightMapper.mapToFlightDto(flight)); });

		return flightDtos;
	}
	
}
