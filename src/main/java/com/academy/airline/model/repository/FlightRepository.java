package com.academy.airline.model.repository;

import com.academy.airline.model.entity.Flight;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.math.BigInteger;
import java.time.LocalDateTime;

public interface FlightRepository extends JpaRepository<Flight, BigInteger> {
	List<Flight> findByArrivalTimeAfterAndDepartureTimeBefore(LocalDateTime from, LocalDateTime to);
}
