package com.example.demo.controllers;

import com.example.demo.contract.Car;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("hello") // localhost:8080/hello
public class HelloController {

    @GetMapping("exception")
    public ResponseEntity throwException() throws Exception {
        throw new Exception("testowy blad");
    }

    @GetMapping("test") // localhost:8080/hello/test z metoda HttpGet
    public ResponseEntity<String> test() {
        ResponseEntity<String> response = new ResponseEntity<String>("Hello World", HttpStatus.OK);
        return response;
    }

    @GetMapping("model")// localhost:8080/hello/model z metoda HttpGet
    public ResponseEntity<Car> getNewCarModel() {

//        ResponseEntity<Car> response = new ResponseEntity<Car>(new Car(
//                "Audi",
//                "GD0001",
//                100000,
//                false,
//                30000.0), HttpStatus.OK);

        ResponseEntity response = ResponseEntity.ok(new Car(
                "Audi",
                "GD0001",
                100000,
                false,
                30000.0)
                );
        return response;
    }

    @PostMapping("model")// localhost:8080/hello/model z metoda HttpPost
    public ResponseEntity<Car> saveCar(
            @RequestBody Car car){
        return ResponseEntity.ok(car);
    }

    @GetMapping("test/{some_value}")
    public ResponseEntity pathParams(@PathVariable("some_value") String pathParam, @RequestParam("name") String name){
        return ResponseEntity.ok(pathParam+name);
    }

    @GetMapping("test/query")
    public ResponseEntity queryParams(@RequestParam("name") String name){
        return ResponseEntity.ok(name);
    }
}
