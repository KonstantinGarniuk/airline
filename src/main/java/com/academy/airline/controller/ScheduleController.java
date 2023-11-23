package com.academy.airline.controller;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


import com.academy.airline.dto.FlightDto;
import com.academy.airline.dto.GatesDto;
import com.academy.airline.service.FlightService;
import com.academy.airline.service.GateSetupService;
import com.academy.airline.util.validation.DateTimeValidator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        return "Schedule";
    }

    @PostMapping(value = "/schedule")
    // public String setFlightInfo(@RequestParam GatesDto gatesInfo) {
    public String setFlightInfo(@RequestParam(required = false) String departureGate, 
                                @RequestParam(required = false) String arrivalGate, 
                                @RequestParam BigInteger flightId) {
        GatesDto gatesInfo = GatesDto.builder()
                            .departureGate(departureGate) 
                            .arrivalGate(arrivalGate)
                            .flightId(flightId)
                            .build();
        gateSetupService.updateGates(gatesInfo);
        return "Schedule";
    }
}
