package com.example.demo.controllers;

import com.example.demo.contract.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Period;

@RestController
@RequestMapping("homework")
public class HomeworkController {

    @GetMapping("/test")
    @ResponseBody
    public ResponseEntity<Object> testMapping(@RequestParam("query") String query) {
        return ResponseEntity.ok("path:test query:" + query);
    }

    @GetMapping("{path}")
    public ResponseEntity testMapping(@PathVariable("path") String path, @RequestParam("query") String query){
        return ResponseEntity.ok("path:" + path+ " query:" + query);
    }

    @PostMapping("/person")
    @ResponseBody
    public ResponseEntity<Object> postPersonMapping(@RequestBody Person person) {
        return ResponseEntity.ok(person);
    }

    @PutMapping("/person/{id}")
    @ResponseBody
    public ResponseEntity<Object> PutPersonMapping(@RequestBody Person person, @PathVariable int id) {
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/person/{id}")
    @ResponseBody
    public ResponseEntity<Object> deletePersonMapping(@PathVariable int id) {
        return ResponseEntity.ok(id);
    }
}
