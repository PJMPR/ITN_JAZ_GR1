package com.example.demo.controllers;

import com.example.demo.contract.Person;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


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

        @DeleteMapping("person/{id}")
        public ResponseEntity<String> deletePerson(@PathVariable("id") String id){
            return ResponseEntity.ok("");
        }

        @GetMapping("{path}")
        public ResponseEntity pathParam(@PathVariable("path") String path, @RequestParam("query") String query){
            return ResponseEntity.ok("path:" + path + " query:" + query)
        }
}