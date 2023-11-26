package com.academy.airline.dto;

import java.math.BigInteger;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RouteResponseDto {
    BigInteger id;
    private String departureAirport;
	private String departureTime;
    private String destinationAirport;
	private String arrivalTime;
    private String status;
	private Integer price;
    private Integer seatsAvailable;
}
