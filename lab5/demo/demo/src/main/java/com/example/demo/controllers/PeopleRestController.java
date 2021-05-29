package com.example.demo.controllers;

import com.example.demo.contract.Person;
import com.example.demo.services.PeopleDataService;
import com.example.demo.services.PeopleService;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("people") // localhost:8080/people
public class PeopleRestController {


    final private PeopleDataService dataService;


    public PeopleRestController( PeopleDataService dataService)
    {
        this.dataService =dataService;
    }

    @GetMapping()
    public ResponseEntity<List<Person>> getAll(@RequestParam("name") @DefaultValue("") String name){

        if(name==null || name == "")
            return ResponseEntity.ok(dataService.getAll());
        return ResponseEntity.ok(dataService.getByName(name));
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> getById(@PathVariable("id") int id){
        Person result = dataService.getById(id);
        if(result==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @PostMapping()
    public ResponseEntity<Person> savePerson(@RequestBody Person person){

        dataService.save(person);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") int id, @RequestBody Person person){

        Person result = dataService.update(id, person);
        if(result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePerson(@PathVariable("id") int id){
        Person deletedPerson = dataService.delete(id);
        if(deletedPerson==null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

}
