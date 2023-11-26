package com.academy.airline.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.academy.airline.dto.BookingDto;
import com.academy.airline.model.entity.Account;
import com.academy.airline.model.entity.Flight;
import com.academy.airline.model.entity.Ticket;
import com.academy.airline.model.entity.TicketStatus;
import com.academy.airline.model.repository.FlightRepository;
import com.academy.airline.model.repository.TicketRepository;
import com.academy.airline.service.BookingService;
import com.academy.airline.service.TicketPriceService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService{
    private final FlightRepository flightRepository;
    private final TicketPriceService ticketPriceService;
    private final TicketRepository ticketRepository;

    @Override
    public void bookTickets(BookingDto bookingInfo, Account account) {
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < bookingInfo.getSeatsRequared(); i++) {
            Flight flight;
            Ticket ticket;
            if(bookingInfo.getDirectFlightId() != null) {
                flight = flightRepository.getReferenceById(bookingInfo.getDirectFlightId());
                ticket = Ticket.builder()
                                    .account(account)
                                    .flight(flight)
                                    .status(TicketStatus.BOOKED)
                                    .luggage(25)
                                    .price(ticketPriceService.countTicketPrice(flight, account))
                                    .build();
                tickets.add(ticket);
            }
            if(bookingInfo.getReturnFlightId() != null) {
                flight = flightRepository.getReferenceById(bookingInfo.getReturnFlightId());
                ticket = Ticket.builder()
                                    .account(account)
                                    .flight(flight)
                                    .status(TicketStatus.BOOKED)
                                    .luggage(25)
                                    .price(ticketPriceService.countTicketPrice(flight, account))
                                    .build();
                tickets.add(ticket);
            }
        }
        ticketRepository.saveAll(tickets);
    }
    
}
