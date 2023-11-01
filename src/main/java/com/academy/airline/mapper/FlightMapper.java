package com.academy.airline.mapper;

import com.academy.airline.dto.FlightDto;
import com.academy.airline.model.entity.Flight;

public class FlightMapper {
	public static FlightDto mapToFlightDto(Flight flight) {
		FlightDto flightDto = FlightDto.builder()
										.departureAirport(flight.getRoute().getDepartureAirport().getName())
										.departureTime(flight.getDepartureTime().toString())
										.departureGate(flight.getDepartureGate().getName())
										.arrivalAirport(flight.getRoute().getArrivalAirport().getName())
										.arrivalTime(flight.getArrivalTime().toString())
										.arrivalGate(flight.getArrivalGate().getName())
										.status(flight.getStatus().getStatus())
										.build();
		return flightDto;
	}
}
