package pl.pjatk.artdem.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.artdem.contract.Car;

//Stwórz RestController, który po wykonaniu zapytania GET na adres
//„localhost:8080/test/hello” zwróci ResponseEntity z Stringiem „Hello world”

@RestController
@RequestMapping("/test")
public class WebAppController {

    //localhost:8080/test/hello
    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.ok("Hello World");
    }

    //Stwórz nowy endpoint w tym samym RestControllerze, który po wykonaniu zapytania GET na adres
    //„localhost:8080/test/model” zwróci nowy obiekt klasy którą wcześniej utworzyłeś (Car).
    @GetMapping("/model")
    public ResponseEntity<Car> getCar(){
        Car car = new Car(
                1,
                "Honda",
                "Accord",
                "2007",
                10000.0,
                true);
        return ResponseEntity.ok(car);
    }

    //Stwórz nowy endpoint w tym samym RestControllerze który po wykonaniu zapytania POST na adres
    //„localhost:8080/test/model” skorzysta z danych dostarczonych w `body` i zwróci nowy obiekt korzystający z tych danych.
    @PostMapping("/model")
    public ResponseEntity<Car> saveCar(@RequestBody Car car){
        return ResponseEntity.ok(car);

//        //example JSON to POST:
//        {
//            "id": 2,
//                "brand": "Ford",
//                "model": "Mondeo",
//                "year": "2017",
//                "price": 20000.0,
//                "sold": false
//        }
    }

}
