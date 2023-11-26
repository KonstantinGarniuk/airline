package com.academy.airline.model.repository;

import com.academy.airline.model.entity.Airport;
import com.academy.airline.model.entity.Location;
import com.academy.airline.model.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RouteRepository extends JpaRepository<Route, Integer> {
    @Query("from Route where departureAirport.location = :location")
    List<Route> findByDepartureLocation(Location location);
    @Query("from Route where destinationAirport.location = :location")
    List<Route> findByDestinationLocation(Location location);
    Route findOneByDepartureAirportAndDestinationAirport(Airport departureAirport, Airport destinationAirport);
}
