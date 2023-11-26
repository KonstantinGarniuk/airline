package com.academy.airline.model.repository;

import com.academy.airline.model.entity.Airport;
import com.academy.airline.model.entity.Flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.math.BigInteger;
import java.time.LocalDateTime;

public interface FlightRepository extends JpaRepository<Flight, BigInteger> {
	List<Flight> findByArrivalTimeAfterAndDepartureTimeBefore(LocalDateTime from, LocalDateTime to);
	
	@Query("from Flight where route.departureAirport = :departureAirport and route.destinationAirport = :destinationAirport and departureTime between :startTime and :endTime")
	List<Flight> selectFlights(Airport departureAirport, Airport destinationAirport, LocalDateTime startTime, LocalDateTime endTime);
}
