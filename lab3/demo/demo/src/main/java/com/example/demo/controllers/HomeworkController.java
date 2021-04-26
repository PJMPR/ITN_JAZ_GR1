
package com.example.demo.controllers;


import com.example.demo.contract.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("homework")
public class HomeworkController {

    @GetMapping("testy") // localhost:8080/hello/test z metoda HttpGet
    public ResponseEntity<String> testy() {
        ResponseEntity<String> response = new ResponseEntity<String>("Hello World", HttpStatus.OK);
        return response;
    }

    @PostMapping("person")
    public ResponseEntity<Person> saveNewPerson(@RequestBody Person person) {
        return ResponseEntity.ok(person);
    }

    @PutMapping("person/{count}")
    public ResponseEntity<Person> saveNewPerson(@PathVariable("count") String count,
                                                @RequestBody Person person) {
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("person/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") String id) {
        return ResponseEntity.ok("");
    }

    @GetMapping("{path}")
    public ResponseEntity pathParams(@PathVariable("path") String path, @RequestParam("query") String query) {
        return ResponseEntity.ok("path:" + path + " query:" + query);
    }
}
