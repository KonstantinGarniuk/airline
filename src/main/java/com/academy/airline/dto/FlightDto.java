package com.academy.airline.dto;

import java.math.BigInteger;
import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlightDto {
	private BigInteger id;
	private String departureAirport;
	private String departureTime;
	private String departureGate;
	private Set<String> availableDepartureGates;
	private String arrivalAirport;
	private String arrivalTime;
	private String arrivalGate;
	private Set<String> availableArrivalGates;
	private String status;
	private Integer price;
}
