package com.academy.airline.controller;

import java.math.BigInteger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.academy.airline.model.entity.TicketStatus;
import com.academy.airline.service.TicketService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;
    
    @GetMapping(value = "/ticket/cancel")
    public String cancelTicket(@RequestParam BigInteger ticket, Model model) {
        model.addAttribute("ticketId", ticket);
        return "cancelTicket";
    }

    @PostMapping(value = "/ticket/cancel")
    public String confirmTicketCancelation(@RequestParam BigInteger ticketId, Model model) {
        ticketService.updateTicketStatus(ticketId, TicketStatus.CANCELED);
        return "redirect:/account";
    }
}
