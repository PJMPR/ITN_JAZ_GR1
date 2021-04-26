package pl.pjatk.JoaKoe.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.JoaKoe.contract.Person;


@RestController
@RequestMapping("homework") // localhost:8080/homework
public class PersonController {

    @GetMapping("{path}")
    public ResponseEntity pathParamsQuery(@PathVariable("path") String pathParam, @RequestParam("query") String queryParam){
        return ResponseEntity.ok("path:" + pathParam + " query:" + queryParam);
    }

    @PostMapping("person") // localhost:8080/homework/person
    public ResponseEntity<Person> person(
            @RequestBody Person person){
        return ResponseEntity.ok(person);
    }

    @PutMapping("person/{path}") // localhost:8080/homework/person/1
    public ResponseEntity<Person> person(
            @PathVariable("path") String path,
            @RequestBody Person person){
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("person/{path}") // localhost:8080/homework/person/1
    public ResponseEntity<String> person(
            @PathVariable("path") String path){
        return ResponseEntity.ok("");
    }
}
