package com.academy.airline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CharterController {
    @GetMapping(value = "/charter")
    public String charterOrdering(Model model) {
        return "/Charter";
    }
}
