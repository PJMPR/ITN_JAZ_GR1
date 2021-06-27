package com.example.demo.controllers;

import com.example.demo.contract.Movie;
import com.example.demo.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieRestController {

    final
    MovieService service;

    public MovieRestController(MovieService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Movie>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Movie> getById(@PathVariable("id") int id){
        Movie result = service.getById(id);
        if(result==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @PostMapping()
    public ResponseEntity<Movie> savePerson(@RequestBody Movie movie){
        service.saveMovie(movie);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") int id, @RequestBody Movie movie){

        Movie result = service.Update(id, movie);
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