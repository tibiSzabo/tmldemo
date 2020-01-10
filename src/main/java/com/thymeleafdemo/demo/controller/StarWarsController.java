package com.thymeleafdemo.demo.controller;

import com.thymeleafdemo.demo.service.StarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StarWarsController {

    private final StarWarsService starWarsService;

    @Autowired
    public StarWarsController(StarWarsService starWarsService) {
        this.starWarsService = starWarsService;
    }

    @GetMapping(value = {"/star-wars"})
    public String getStarWarsPage(Model model) {
        return "star-wars";
    }

    @GetMapping(value = {"/star-wars/{id}"})
    public String getEmployees(Model model, @PathVariable String id) {
        model.addAttribute("headers", starWarsService.getStarWarsPeopleTableHeader());
        model.addAttribute("data", starWarsService.getStarWarsPersonById(id));
        return "fragments :: table-starWars";
    }
}
