package com.academy.airline.service;


import com.academy.airline.model.entity.Airport;
import com.academy.airline.model.entity.Location;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AirportServiceTest {
    @Autowired
    AirportService airportService;
    @Autowired
    LocationService locationService;

    List<Airport> airports;
    List<Location> locations;
    @BeforeAll
    public void initTestData() {
        airports = new ArrayList<>();
        locations = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Location location = Location.builder().country("testCountry" + i).town("testTown").build();
            locations.add(location);
            Airport airport = Airport.builder().name("testName" + i).location(location).build();
            airports.add(airport);
        }
        locationService.saveAll(locations);
        airportService.saveAll(airports);
    }

    @AfterAll
    public void removeTestData() {
        airportService.removeSelected(airports);
        locationService.removeSelected(locations);
    }

    @Test
    public void selectingByNameTest() {
        List<Airport> result = airportService.getByName(airports.get(3).getName());
        for (Airport airport: result) {
            Assert.isTrue(airport.getName().contains(airports.get(3).getName()), "AirportService error selecting by name");
        }
    }
    @Test
    public void selectingByNameLocation() {
        Location location = airports.get(3).getLocation();
        List<Airport> result = airportService.getByLocation(location);
        for (Airport airport: result) {
            Assert.isTrue(airport.getName().contains(airports.get(3).getName()), "AirportService error selecting by name");
        }
    }
}
