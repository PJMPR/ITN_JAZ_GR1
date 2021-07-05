package pl.pjatk.artdem.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;

//Stwórz nowy RestController, który przyjmie bazowy adres jako `/homework` a następnie zaimplementuj w nim metodę GET która
//w jednym z przypadków przyjmie dowolny PathVariable, w innym RequestParam i zwrócą podane informacje jako encje.
//Stwórz dodatkowo logikę dla pozostałych metod PUT / POST / DELTE.
//Dla metody PUT skorzystaj z PathVariable oraz RequestBody.
//Dla metody POST skorzystaj z RequestBody.
//Dla metody DELETE skorzystaj z PathVariable.
//Niech metody PUT oraz POST zwrócą dostarczone dane, natomiast metoda DELETE niech zwraca jedynie HTTP status 200 bez żadnego body.

@RestController
@RequestMapping("/homework")
public class HomeworkController {


    @GetMapping("/pathvar/{some_value}")
    public ResponseEntity<Entity> pathParams(@PathVariable("some_value") String pathParam) {
        Entity entity = new Entity("ent", 1, pathParam.toCharArray());
        return ResponseEntity.ok(entity);
        //przykladowe zapytanie GET:
        //localhost:8080/homework/pathvar/SomeValue
    }

    @GetMapping("/query")
    public ResponseEntity<Entity> queryParams(@RequestParam("reqParam") String queryParam) {
        Entity entity = new Entity("ent", 1, queryParam.toCharArray());
        return ResponseEntity.ok(entity);
        //przykladowe zapytanie GET:
        //localhost:8080/homework/query?reqParam=SomeValue
    }

    @PutMapping("/pathvar/{some_value}")
    public ResponseEntity<String> putPathParams(@PathVariable("some_value") String pathParam) {
        return ResponseEntity.ok(pathParam);
        //przykladowe zapytanie PUT:
        //localhost:8080/homework/pathvar/SomeValue
    }

    @PutMapping("/body")
    public ResponseEntity<String> putBodyParams(@RequestBody String bodyParam) {
        return ResponseEntity.ok(bodyParam);
        //przykladowe zapytanie PUT:
        //localhost:8080/homework/body
        //message body:
        // SomeValue
    }

    @PostMapping("/body")
    public ResponseEntity<String> postBodyParams(@RequestBody String bodyParam) {
        return ResponseEntity.ok(bodyParam);
        //przykladowe zapytanie POST:
        //localhost:8080/homework/body
        //message body:
        // SomeValue
    }

    @DeleteMapping("/pathvar/{some_value}")
    public ResponseEntity<String> deletePathParams(@PathVariable("some_value") String pathParam) {
        return ResponseEntity.ok(null);
        //przykladowe zapytanie DELETE:
        //localhost:8080/homework/pathvar/SomeValue
    }
}
