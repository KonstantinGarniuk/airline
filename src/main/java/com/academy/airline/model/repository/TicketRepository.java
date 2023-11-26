package com.academy.airline.model.repository;

import com.academy.airline.model.entity.Flight;
import com.academy.airline.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface TicketRepository  extends JpaRepository<Ticket, BigInteger> {
    List<Ticket> findByFlight(Flight flight);
}
