package com.academy.airline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.academy.airline.dto.CreateAccountDto;
import com.academy.airline.service.AccountService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RegistrationController {
    private final AccountService accountService;

    @GetMapping(value = "/registration")
    public String gerRegistration(Model model) {
        model.addAttribute("createAccount", new CreateAccountDto());
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String postRegistration(@ModelAttribute CreateAccountDto createAccountDto, Model model) throws Exception {
        accountService.seveAccount(createAccountDto);
        return "redirect:/account";
    }
}
