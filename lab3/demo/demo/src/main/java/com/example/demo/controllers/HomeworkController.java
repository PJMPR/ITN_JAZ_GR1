package com.example.demo.controllers;

import com.example.demo.contract.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("homework")
public class HomeworkController {

    @GetMapping()
    public ResponseEntity ok() {
        return ResponseEntity.ok("ok");
    }

    @GetMapping("{path}")
    public ResponseEntity params(@PathVariable("path") String path, @RequestParam("query") String query) {
        return ResponseEntity.ok("path:" + path + " query:" + query);
    }

    @PostMapping("person")
    public ResponseEntity postPerson(@RequestBody Person person) {
        return ResponseEntity.ok(person);
    }

    @PutMapping("person/{ID}")
    public ResponseEntity updatePerson(@PathVariable("ID") String pathID, @RequestBody Person person) {
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("person/{ID}")
    public ResponseEntity deletePerson(@PathVariable("ID") String pathID) {
        return ResponseEntity.ok("");
    }

}
