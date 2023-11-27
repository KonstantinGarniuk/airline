package com.academy.airline.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.academy.airline.dto.TicketDto;
import com.academy.airline.mapper.TicketMapper;
import com.academy.airline.model.entity.Account;
import com.academy.airline.model.entity.Ticket;
import com.academy.airline.model.entity.TicketStatus;
import com.academy.airline.model.repository.TicketRepository;
import com.academy.airline.service.TicketService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    @Override
    public List<TicketDto> getTickets(Account account) {
        List<Ticket> tickets = ticketRepository.findByAccount(account);
        List<TicketDto> result = new ArrayList<>();
        tickets.forEach(ticket -> result.add(TicketMapper.mapToTicketDto(ticket)));
        return result;
    }

    @Override
    public void updateTicketStatus(BigInteger id, TicketStatus status) {
        Ticket ticket = ticketRepository.getReferenceById(id);
        ticket.setStatus(status);
        ticketRepository.save(ticket);
    }
    
}
