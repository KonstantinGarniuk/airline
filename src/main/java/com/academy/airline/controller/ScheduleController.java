package com.academy.airline.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


import com.academy.airline.dto.FlightDto;
import com.academy.airline.service.FlightService;
import com.academy.airline.util.validation.DateTimeValidator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ScheduleController {
    private final FlightService flightService;

    @GetMapping(value = "/schedule")
    public String getSchedule(Model model, @RequestParam(required = false) Map<String,String> params) {
        /* TODO
        * two date inputs and submit button
        * check for selected start and end time
        * if selected show all flights with departure time between start and end time
        * if not selected show all flights with arrival time isn't come yet and departure time is less then +1 days from now
        * */
        LocalDateTime from = DateTimeValidator.validateTime(params.get("from"), LocalDate.now().atStartOfDay());
        LocalDateTime to = DateTimeValidator.validateTime(params.get("to"), from.plusDays(1));
        List<FlightDto> flights = flightService.getFlights(from, to);
        model.addAttribute("flights", flights);
        return "Schedule";
    }
}
