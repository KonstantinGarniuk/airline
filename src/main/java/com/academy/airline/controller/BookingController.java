package com.academy.airline.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.academy.airline.dto.BookingDto;
import com.academy.airline.dto.RouteRequestDto;
import com.academy.airline.model.entity.Account;
import com.academy.airline.service.BookingService;
import com.academy.airline.service.FlightService;
import com.academy.airline.service.LocationService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;
    private final LocationService locationService;
    private final FlightService flightService;

    @GetMapping(value = "/booking")
    public String getBooking(
        @ModelAttribute RouteRequestDto routeRequest, 
        @AuthenticationPrincipal Account account, Model model
    ) {
        if (routeRequest == null) {
            model.addAttribute("routeRequest", new RouteRequestDto());
        } else {
            model.addAttribute("routeRequest", routeRequest);
           
            model.addAttribute("departureAirports", locationService.getDepartureLocations(routeRequest.getDestinationAirport()));
            model.addAttribute("destinationAirports", locationService.getDestinationLocations(routeRequest.getDepartureAirport()));
        }
        model.addAttribute("bookingInfo", new BookingDto());
        
        model.addAttribute("directFlights", flightService.getDirectFlights(routeRequest, account));
        model.addAttribute("returnFlights", flightService.getReturnFlights(routeRequest, account));
        
        return "Booking";
    }

    @GetMapping(value = "/booking/confirm")
    public String bookTickets(@ModelAttribute BookingDto bookingInfo, @AuthenticationPrincipal Account account, Model model) {
        model.addAttribute("bookingInfo", bookingInfo);
        model.addAttribute("directFlight", flightService.getFlight(bookingInfo.getDirectFlightId(), account));
        model.addAttribute("returnFlight",flightService.getFlight(bookingInfo.getReturnFlightId(), account));
        
        return "bookingConfirm";
    }

    @PostMapping(value = "/booking/confirm")
    public String confirmBooking(@ModelAttribute BookingDto bookingInfo, @AuthenticationPrincipal Account account, Model model) {
        bookingService.bookTickets(bookingInfo, account);
        return "redirect:/";
    }
}
