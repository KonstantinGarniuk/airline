package com.academy.airline.model.repository;

import com.academy.airline.model.entity.Airport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface AirportRepository extends JpaRepository<Airport, Integer> {
    Airport findByName(String name);

    @Query("from Airport where location.town = :town")
    Airport findByTown(String town);
}
