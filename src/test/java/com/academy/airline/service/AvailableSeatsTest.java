package com.academy.airline.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.academy.airline.model.entity.Flight;
import com.academy.airline.model.entity.Ticket;
import com.academy.airline.model.entity.TicketStatus;
import com.academy.airline.model.repository.TicketRepository;

@SpringBootTest
class AvailableSeatsTest {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private AvailableSeatsServise availableSeatsServise;

    @Test
    void countSeats_zeroResult_flightIsNull() {
        assertEquals(0, availableSeatsServise.countAvailableSeats(null), "Avaliable seats is not 0");
    }

    @Test
    void countSeats_zeroResult_airplaneIsNull() {
        List<Ticket> tickets = ticketRepository.findAll();
        Ticket ticket = tickets.get(tickets.size() / 2);
        Flight flight = ticket.getFlight();
        flight.setAirplane(null);
        assertEquals(0, availableSeatsServise.countAvailableSeats(flight), "Avaliable seats is not 0");
    }

    @Test
    void countSeats_correctResult_correctInputData() {
        List<Ticket> tickets = ticketRepository.findAll();
        Ticket ticket = tickets.get(tickets.size() / 2);
        Flight flight = ticket.getFlight();
        Integer availableSeats = flight.getAirplane().getType().getEconomyClassSeats() + flight.getAirplane().getType().getFirstClassSeats() - 
                                    ticketRepository.findByFlight(flight).stream().filter(t -> (t.getStatus() != TicketStatus.CANCELED)).toList().size();
        assertEquals(availableSeats, availableSeatsServise.countAvailableSeats(flight), "Incorrect number of available seats");
    }
}
