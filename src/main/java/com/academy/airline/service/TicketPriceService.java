package com.academy.airline.service;

import com.academy.airline.model.entity.Account;
import com.academy.airline.model.entity.Flight;

public interface TicketPriceService {
    Integer countTicketPrice(Flight flight, Account account);
}
