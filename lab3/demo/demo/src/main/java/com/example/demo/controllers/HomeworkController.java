package com.example.demo.controllers;

import com.example.demo.contract.Person;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import javax.websocket.server.PathParam;

@RestController
@RequestMapping("homework")
public class HomeworkController {

        @PostMapping("person")
        public ResponseEntity<Person> savePerson(@RequestBody Person person){
            return ResponseEntity.ok(person);
        }

        @PutMapping("person/{count}")
        public ResponseEntity<Person> savePerson(@PathVariable("count") String count, @RequestBody Person person){
            return ResponseEntity.ok(person);
        }
}