package com.academy.airline.mapper;

import java.util.HashSet;
import java.util.Set;

import com.academy.airline.dto.FlightDto;
import com.academy.airline.model.entity.Flight;

public class FlightMapper {
	public static FlightDto mapToFlightDto(Flight flight) {
		Set<String> departureGates = new HashSet<>();
		Set<String> arrivalGates = new HashSet<>();
		flight.getRoute().getDepartureAirport().getGates().forEach(gate -> departureGates.add(gate.getName()));
		flight.getRoute().getArrivalAirport().getGates().forEach(gate -> arrivalGates.add(gate.getName()));
		return FlightDto.builder()
										.id(flight.getId())
										.departureAirport(flight.getRoute().getDepartureAirport().getName())
										.departureTime(flight.getDepartureTime().toString())
										.departureGate((flight.getDepartureGate() != null) ?  flight.getDepartureGate().getName() : "")
										.arrivalAirport(flight.getRoute().getArrivalAirport().getName())
										.arrivalTime(flight.getArrivalTime().toString())
										.arrivalGate((flight.getArrivalGate() != null) ? flight.getArrivalGate().getName() : "")
										.status((flight.getStatus() != null) ? flight.getStatus().getStatus() : "")
										.availableDepartureGates(departureGates)
										.availableArrivalGates(arrivalGates)
										.build();
	}
}
