package com.academy.airline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScheduleController {
    @GetMapping(value = "/schedule")
    public String getSchedule(Model model) {
        return "Schedule";
    }
}
