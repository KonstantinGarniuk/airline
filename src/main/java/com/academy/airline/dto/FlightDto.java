package com.academy.airline.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlightDto {
	private String departureAirport;
	private String departureTime;
	private String departureGate;
	private String arrivalAirport;
	private String arrivalTime;
	private String arrivalGate;
	private String status;
	private Integer price;
}
