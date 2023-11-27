package com.academy.airline.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.academy.airline.mapper.AccountMapper;
import com.academy.airline.model.entity.Account;
import com.academy.airline.model.entity.Person;
import com.academy.airline.service.PersonService;
import com.academy.airline.service.TicketService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AccountController {
    private final PersonService personService;
    private final TicketService ticketService;

    @GetMapping(value = "/login")
    String login() {
        return "login";
    }
    
    @GetMapping(value = "/logout") 
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
         return "redirect:/";
    }

    @GetMapping(value = "/account")
    public String getAccount(@AuthenticationPrincipal Account account, Model model) {
        if (account != null) {
            model.addAttribute("flightsHistory", ticketService.getTickets(account));
            model.addAttribute("accountInfo", AccountMapper.mapToAccountDto(account));
        }        
        model.addAttribute("personInfo", new Person());
        
        return "Account";
    }

    @PostMapping(value = "/account")
    public String updateAccount(
        @ModelAttribute Person personInfo,
        @AuthenticationPrincipal Account account,    
        Model model
    ) throws Exception {
        personService.updatePersonInfo(personInfo, account);
        return "redirect:/account";
    }
}
