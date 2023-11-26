package com.academy.airline.dto;

import java.math.BigInteger;

import lombok.Data;

@Data
public class BookingDto {
    private BigInteger directFlightId;
    private BigInteger returnFlightId;
    private Integer seatsRequared;
}
