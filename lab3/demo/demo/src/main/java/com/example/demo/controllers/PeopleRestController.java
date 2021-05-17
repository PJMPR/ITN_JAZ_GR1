package com.example.demo.controllers;

import com.example.demo.contract.Person;
import com.example.demo.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("people") // localhost:8080/people
public class PeopleRestController {

    final
    PeopleService service;

    public PeopleRestController(PeopleService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Person>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> getById(@PathVariable("id") int id){
        Person result = service.getById(id);
        if(result==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @PostMapping()
    public ResponseEntity<Person> savePerson(@RequestBody Person person){
        service.savePerson(person);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") int id, @RequestBody Person person){

        Person result = service.Update(id, person);
        if(result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePerson(@PathVariable("id") int id){
        Person deletedPerson = service.delete(id);
        if(deletedPerson==null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

}