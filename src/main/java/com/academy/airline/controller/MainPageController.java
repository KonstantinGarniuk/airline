package com.academy.airline.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainPageController {
    @GetMapping(value = "/")
    public String getMain(Model model) {
        return "MainPage";
    }
}
