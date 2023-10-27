package com.academy.airline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
    @GetMapping(value = "/account")
    public String getAccount(Model model) {
        return "Account";
    }
}
