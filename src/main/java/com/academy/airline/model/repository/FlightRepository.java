package com.academy.airline.model.repository;

import com.academy.airline.model.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface FlightRepository extends JpaRepository<Flight, BigInteger> {
}
