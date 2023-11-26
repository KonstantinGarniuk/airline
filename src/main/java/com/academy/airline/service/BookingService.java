package com.academy.airline.service;

import com.academy.airline.dto.BookingDto;
import com.academy.airline.model.entity.Account;

public interface BookingService {
    void bookTickets(BookingDto bookingInfo, Account account);
}
