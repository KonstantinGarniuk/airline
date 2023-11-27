package com.academy.airline.dto;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TicketDto {
    private BigInteger id;
    private String departureAirport;
    private String departureTIme;
    private String destinationAirport;
    private String arrivalTime;
    private Integer luggage;
    private Integer price;
    private String status;
}
