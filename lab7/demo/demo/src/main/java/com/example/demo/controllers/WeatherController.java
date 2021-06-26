package com.example.demo.controllers;

import com.example.demo.contract.WeatherDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("weather")
public class WeatherController {

    @GetMapping("{city}")
    public ResponseEntity getByCity(@PathVariable("city") String city){

        WebClient webClient = WebClient.create("http://api.openweathermap.org");
        WeatherDto response = webClient.get().uri("data/2.5/weather?q=" +
                city +
                "&appid=cb6c6d99aa8697402c79bac521cf7008")
                .exchangeToMono(x->{
                   if(x.statusCode().is2xxSuccessful())
                       return x.bodyToMono(WeatherDto.class);
                   else
                       return x.createException().flatMap(Mono::error) ;
                }).block();

        return ResponseEntity.ok(response);
    }
}
