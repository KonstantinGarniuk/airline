package com.academy.airline.service;

import com.academy.airline.model.entity.Flight;

public interface AvailableSeatsServise {
    Integer countAvailableSeats(Flight flight);
}
