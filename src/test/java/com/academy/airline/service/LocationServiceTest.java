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
public class LocationServiceTest {
    @Autowired
    private LocationService locationService;

    private List<Location> locations;

    @BeforeAll
    public void initTestData() {
        locations = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Location location = Location.builder().country("testCountry" + i).town("testTown").build();
            locations.add(location);
        }
        locationService.saveAll(locations);
    }

    @AfterAll
    public void removeTestData() {
        locationService.removeSelected(locations);
    }

    @Test
    public void groupLocationsGettingByCountry() {
        List<Location> result = locationService.getByCountry(locations.get(0).getCountry());
        for (Location location: result) {
            Assert.isTrue(location.getCountry().contains(locations.get(0).getCountry()), "LocationService error selecting by country");
        }
    }

}
