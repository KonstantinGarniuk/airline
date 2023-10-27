package com.academy.airline.model.repository;

import com.academy.airline.model.entity.Airport;
import com.academy.airline.model.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AirportRepository extends JpaRepository<Airport, Integer> {
    List<Airport> findByName(String name);
    List<Airport> findByLocation(Location location);
}
