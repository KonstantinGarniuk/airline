package com.academy.airline.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RouteRequestDto {
    private String departureAirport;
    private String destinationAirport;
    private LocalDate departureDate;
    private LocalDate returningDate;
    private Integer seatsRequared = 1;
}
