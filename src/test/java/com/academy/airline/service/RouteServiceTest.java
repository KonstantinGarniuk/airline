package com.academy.airline.service;

import com.academy.airline.model.entity.Airport;
import com.academy.airline.model.entity.Location;
import com.academy.airline.model.entity.Route;
import com.academy.airline.model.repository.RouteRepository;
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
public class RouteServiceTest {
    @Autowired
    private RouteService routeService;
    @Autowired
    AirportService airportService;

    List<Airport> airports;
    List<Route> routes;

    @BeforeAll
    public void initTestData() {
        airports = new ArrayList<>();
        routes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Airport airport = Airport.builder().name("testName" + i).build();
            airports.add(airport);
        }
        airportService.saveAll(airports);
        for(int i = 0; i < 5; i++) {
            Route route = Route.builder().departureAirport(airports.get(i)).arrivalAirport(airports.get(9 - i)).build();
            routes.add(route);
            route = Route.builder().departureAirport(airports.get(9 - i)).arrivalAirport(airports.get(i)).build();
            routes.add(route);
        }
        routeService.saveAll(routes);
    }

    @AfterAll
    public void removeTestData() {
        routeService.removeSelected(routes);
        airportService.removeSelected(airports);
    }

    @Test
    public void gettingByDepartureAirport() {
        Airport airport = airports.get(0);
        List<Route> result = routeService.getByDepartureAirport(airport);
        for (Route route: result) {
            Assert.isTrue(route.getDepartureAirport().getName().equals(airport.getName()),"RouteService selected wrong departure airport");
        }
    }

    @Test
    public void gettingByArrivalAirport() {
        Airport airport = airports.get(0);
        List<Route> result = routeService.getByArrivalAirport(airport);
        for (Route route: result) {
            Assert.isTrue(route.getDepartureAirport().getName().equals(airport.getName()),"RouteService selected wrong arrival airport");
        }
    }

    @Test
    public void gettingByDepartureAndArrival() {
        Airport departure = airports.get(1);
        Airport arrival = airports.get(8);
        Route route = routeService.getRoute(departure, arrival);
        Assert.notNull(route, "do not selected route");
        Assert.isTrue(
                route.getDepartureAirport().getName().equals(departure.getName()) &
                        route.getArrivalAirport().getName().equals(arrival.getName()),
                "selected wrong route"
        );
    }

    @Test
    public void gettingNotExistingByDepartureAndArrival() {
        Airport departure = airports.get(1);
        Airport arrival = airports.get(7);
        Route route = routeService.getRoute(departure, arrival);
        Assert.isNull(route, "selected not existing route route");
    }
}
