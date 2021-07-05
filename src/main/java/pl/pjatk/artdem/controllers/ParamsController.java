package pl.pjatk.artdem.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

//Stwórz RestController, po wykonaniu zapytania GET na adres „localhost:8080/test/hello/{someValue}”
//zwróci ResponseEntity z Stringiem {someValue}

@RestController
@RequestMapping("/test")
public class ParamsController {

    //localhost:8080/test/hello
    @GetMapping("/hello/{some_value}")
    public ResponseEntity<String> pathParams(@PathVariable("some_value") String pathParam){
        return ResponseEntity.ok(pathParam);
    }

    //Stwórz RestController, który po wykonaniu zapytania GET na adres „localhost:8080/test/hello/query?reqParam={someValue}”
    //zwróci ResponseEntity z Stringiem {someValue}
    @GetMapping("/hello/query")
    public ResponseEntity<String> queryParams(@RequestParam("reqParam") String queryParam){
        return ResponseEntity.ok(queryParam);
    }

}
