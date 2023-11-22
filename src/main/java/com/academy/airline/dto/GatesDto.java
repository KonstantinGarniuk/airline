package com.academy.airline.dto;

import java.math.BigInteger;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GatesDto {
    private String departureGate;
    private String arrivalGate;
    private BigInteger flightId;  
}
