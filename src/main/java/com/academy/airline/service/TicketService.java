package com.academy.airline.service;

import java.math.BigInteger;
import java.util.List;

import com.academy.airline.dto.TicketDto;
import com.academy.airline.model.entity.Account;
import com.academy.airline.model.entity.TicketStatus;

public interface TicketService {
    List<TicketDto> getTickets(Account account);
    void updateTicketStatus(BigInteger id, TicketStatus status);
}
