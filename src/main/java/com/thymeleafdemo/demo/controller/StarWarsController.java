package com.thymeleafdemo.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StarWarsController {

    @GetMapping(value = {"/star-wars"})
    public String getStarWarsPage(Model model) {
        return "star-wars";
    }

    @GetMapping(value = {"/star-wars/{id}"})
    public String getEmployees(Model model, @PathVariable("id") Long id) {

        return "index";
    }
}
