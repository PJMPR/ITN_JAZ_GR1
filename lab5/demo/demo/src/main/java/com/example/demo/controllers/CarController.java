package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("cartest")
public class CarController {


    @GetMapping()
    public ResponseEntity<String> getAll(){
        return ResponseEntity.ok("");
    }

}