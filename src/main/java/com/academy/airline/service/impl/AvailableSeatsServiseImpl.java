package com.academy.airline.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.academy.airline.model.entity.Airplane;
import com.academy.airline.model.entity.Flight;
import com.academy.airline.model.entity.Ticket;
import com.academy.airline.model.entity.TicketStatus;
import com.academy.airline.model.repository.TicketRepository;
import com.academy.airline.service.AvailableSeatsServise;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AvailableSeatsServiseImpl implements AvailableSeatsServise {
    private final TicketRepository ticketRepository;

    @Override
    public Integer countAvailableSeats(Flight flight) {
        Airplane airplane = flight.getAirplane();
        if(airplane == null) {
            return 0;
        }
        Integer seatsAmount = airplane.getType().getFirstClassSeats() + airplane.getType().getEconomyClassSeats();
        List<Ticket> tickets = ticketRepository.findByFlight(flight).stream()
                                                .filter(ticket -> (ticket.getStatus() != TicketStatus.CANCELED))
                                                .toList();
        return seatsAmount - tickets.size();
    }
    
}
