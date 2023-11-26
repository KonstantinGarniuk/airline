package com.academy.airline.service.impl;

import org.springframework.stereotype.Service;

import com.academy.airline.model.entity.Account;
import com.academy.airline.model.entity.Flight;
import com.academy.airline.service.TicketPriceService;

@Service
public class TicketPriceServiceImpl implements TicketPriceService {
    private static final Float CILOMETER_PRICE = 0.5f;

    @Override
    public Integer countTicketPrice(Flight flight, Account account) {
        Integer distance = flight.getRoute().getDistance();
        Float discount = account.getDiscount().getDiscount() / 100f;
        return Math.round(CILOMETER_PRICE * distance * (1 - discount));
    }
    
}
