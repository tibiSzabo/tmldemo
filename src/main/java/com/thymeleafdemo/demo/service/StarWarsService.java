package com.thymeleafdemo.demo.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StarWarsService {

    public List<String> getStarWarsPeopleTableHeader() {
        return Arrays.asList("Name", "Height", "Mass", "Hair color", "Skin color", "Eye color", "Birth year", "Gender");
    }

}
