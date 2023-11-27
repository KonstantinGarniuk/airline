package com.academy.airline.mapper;

import java.time.format.DateTimeFormatter;

import com.academy.airline.dto.TicketDto;
import com.academy.airline.model.entity.Ticket;

public class TicketMapper {
    private TicketMapper() {}

    public static TicketDto mapToTicketDto(Ticket ticket) {
        return TicketDto.builder()
            .id(ticket.getId())
            .departureAirport(ticket.getFlight().getRoute().getDepartureAirport().getName())
            .departureTIme(ticket.getFlight().getDepartureTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")))
            .destinationAirport(ticket.getFlight().getRoute().getDestinationAirport().getName())
            .arrivalTime(ticket.getFlight().getArrivalTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")))
            .luggage(ticket.getLuggage())
            .price(ticket.getPrice())
            .status(ticket.getStatus().getStatus())
            .build();
    }
}
