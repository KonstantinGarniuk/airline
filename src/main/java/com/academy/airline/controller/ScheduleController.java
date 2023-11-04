package com.academy.airline.controller;

import java.util.List;
import java.util.Map;


import com.academy.airline.dto.FlightDto;
import com.academy.airline.service.FlightService;
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
    public String getSchedule(Model model, @RequestParam Map<String,String> params) {
        /* TODO
        * two date inputs and submit button // done
        * check for selected start and end time
        * if selected show all flights with departure time between start and end time
        * if not selected show all flights with arrival time isn't come yet and departure time is less then +2 days from now
        * */
        List<FlightDto> flights = flightService.getFlights(params.get("from"), params.get("to"));
        model.addAttribute("flights", flights);
        return "Schedule";
    }
}
