package pl.pjatk.artdem.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/movies")
public class WebAppController {

    //Dodaj nowy endpoint `/excpetion`, który po wywoaniu go będzie rzucał dowolny exception (RuntimeException, NullPointerException, etc…).
    @GetMapping("/exception")
    public ResponseEntity throwException() throws Exception {
        throw new Exception("testowy blad");
        //przykladowy request:
        //localhost:8080/movies/exception
    }


}
