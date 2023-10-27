package com.academy.airline.model.repository;

import com.academy.airline.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface TicketRepository  extends JpaRepository<Ticket, BigInteger> {
}
