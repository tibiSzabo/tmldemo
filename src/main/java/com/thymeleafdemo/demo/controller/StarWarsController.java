package com.thymeleafdemo.demo.controller;

import com.thymeleafdemo.demo.entity.StarWarsPerson;
import com.thymeleafdemo.demo.service.StarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @PostMapping(value = {"/star-wars"})
    public String getEmployees(Model model, @RequestBody StarWarsPerson starWarsPerson) {
        model.addAttribute("headers", starWarsService.getStarWarsPeopleTableHeader());
        model.addAttribute("data", starWarsPerson);
        return "fragments :: table-starWars";
    }
}
