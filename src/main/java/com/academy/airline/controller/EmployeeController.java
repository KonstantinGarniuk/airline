package com.academy.airline.controller;

import java.math.BigInteger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.academy.airline.dto.GetEmployeeDto;
import com.academy.airline.model.entity.Job;
import com.academy.airline.model.entity.Role;
import com.academy.airline.service.EmployeeService;
import com.academy.airline.service.impl.HireEmployeeDto;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;


    @GetMapping(value = "/employee")
    public String getEmployees(@ModelAttribute GetEmployeeDto requaredEmployee, Model model) {
        model.addAttribute("requaredEmployee", new GetEmployeeDto());
        model.addAttribute("employeeList", employeeService.getEmployeeList(requaredEmployee));
        model.addAttribute("filterInfo", requaredEmployee);
        return "employee";
    }

    @GetMapping(value = "/employee/dismiss")
    public String dismissEmployeeConfirm(@RequestParam BigInteger id, Model model) {
        model.addAttribute("employeeId", id);
        return "dismissEmployee";
    }

    @PostMapping(value = "/employee/dismiss")
    public String dismissEmployee(@RequestParam BigInteger id, Model model) {
        employeeService.dismissEmployee(id);
        return "redirect:/employee";
    }

    @GetMapping(value = "/employee/hire")
    public String hireEmployee(Model model) {
        model.addAttribute("employeeInfo", new HireEmployeeDto());
        model.addAttribute("jobs", Job.values());
        model.addAttribute("roles", Role.values());
        return "hireEmployee";
    }

    @PostMapping(value = "employee/hire")
    public String hireEmployeePost(@ModelAttribute HireEmployeeDto employeeInfo, Model model) throws Exception {
        employeeService.hireEmployee(employeeInfo);
        return "redirect:/employee";
    }
}
