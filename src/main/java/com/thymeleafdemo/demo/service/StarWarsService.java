package com.thymeleafdemo.demo.service;

import com.google.gson.Gson;
import com.thymeleafdemo.demo.entity.StarWarsPerson;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Service
public class StarWarsService {

    public List<String> getStarWarsPeopleTableHeader() {
        return Arrays.asList("Name", "Height", "Mass", "Hair color", "Skin color", "Eye color", "Birth year", "Gender");
    }

    public StarWarsPerson getStarWarsPersonById(String id) {
        try {
        URL url = new URL("https://swapi.co/api/people/" + id + "/?format=json");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setUseCaches(false);
        con.setAllowUserInteraction(false);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-length", "0");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        con.connect();
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line+"\n");
        }
        br.close();
        con.disconnect();
        return new Gson().fromJson(sb.toString(), StarWarsPerson.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
