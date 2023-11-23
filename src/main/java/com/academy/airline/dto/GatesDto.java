package com.academy.airline.dto;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GatesDto {
    private String departureGate;
    private String arrivalGate;
    private BigInteger flightId;  
}
