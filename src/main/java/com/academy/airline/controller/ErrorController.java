package com.academy.airline.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

@ControllerAdvice
public class ErrorController {
    @GetMapping(value = "/error")
    public String errorPage() {
        return "error";
    }
}
