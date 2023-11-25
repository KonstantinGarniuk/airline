package com.academy.airline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.academy.airline.dto.RouteRequestDto;

@Controller
public class BookingController {
    @GetMapping(value = "/booking")
    public String getBooking(@ModelAttribute RouteRequestDto routeRequest, Model model) {
        model.addAttribute("routeRequest", new RouteRequestDto());
        return "Booking";
    }
}
