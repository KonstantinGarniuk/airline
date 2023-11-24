package com.academy.airline.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


import com.academy.airline.dto.FlightDto;
import com.academy.airline.dto.GatesDto;
import com.academy.airline.model.entity.FlightStatus;
import com.academy.airline.service.FlightService;
import com.academy.airline.service.GateSetupService;
import com.academy.airline.util.validation.DateTimeValidator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ScheduleController {
    private final FlightService flightService;
    private final GateSetupService gateSetupService;

    @GetMapping(value = "/schedule")
    public String getSchedule(Model model, @RequestParam(required = false) Map<String,String> params) {
        LocalDateTime from = DateTimeValidator.validateTime(params.get("from"), LocalDate.now().atStartOfDay());
        LocalDateTime to = DateTimeValidator.validateTime(params.get("to"), from.plusDays(1));
        List<FlightDto> flights = flightService.getFlights(from, to);
        model.addAttribute("flights", flights);
        model.addAttribute("gatesInfo", new GatesDto());
        model.addAttribute("statuses", FlightStatus.values());
        return "Schedule";
    }

    @PostMapping(value = "/schedule")
    public String setFlightInfo(@ModelAttribute GatesDto gatesInfo) {
        gateSetupService.updateGates(gatesInfo);
        return "Schedule";
    }
}
