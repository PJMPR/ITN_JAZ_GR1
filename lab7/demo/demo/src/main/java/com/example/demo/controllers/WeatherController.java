package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
@RequestMapping("weather")
public class WeatherController {

    @GetMapping("{city}")
    public ResponseEntity getByCity(@PathVariable("city") String city){

        WebClient webClient = WebClient.create("http://api.openweathermap.org");
        String response = webClient.get().uri("data/2.5/weather?q=" +
                city +
                "&appid=cb6c6d99aa8697402c79bac521cf7008")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return ResponseEntity.ok(response);
    }
}
