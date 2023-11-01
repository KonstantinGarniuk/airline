package com.academy.airline.controller;

import java.util.Map;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ScheduleController {
    @GetMapping(value = "/schedule")
    public String getSchedule(Model model, @RequestParam Map<String,String> params) {
        /* TODO
        * two date inputs and submit button // done
        * check for selected start and end time
        * if selected show all flights with departure time between start and end time
        * if not selected show all flights with arrival time isn't come yet and departure time is less then +2 days from now
        * */
		System.out.println("Departure time is" + params.get("departure"));
		LocalDateTime departureTime = LocalDateTime.now();
		if(params.get("departure") != null) {
			try {
				departureTime = LocalDate.parse(params.get("departure")).atStartOfDay();
			} catch (DateTimeParseException e) {
				System.out.println("Cannot parse departure time. Set to now.");
			}
		} else {
			System.out.println("Departure time is null. Set to now.");
		}
		System.out.println(departureTime.toString());
		
		//System.out.println(params.get("arrival"));
		//if(!params.get("arrival").isEmpty()) {
		//	LocalDateTime arrivalTime = LocalDate.parse(params.get("arrival")).atTime(23,59);
		//	System.out.println(arrivalTime.toString());
		//}

        return "Schedule";
    }
}
