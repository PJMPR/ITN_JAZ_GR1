package com.example.demo.controllers;


import com.example.demo.contract.Car;
import com.example.demo.services.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cars") // localhost:8080/cars
public class CarRestController {

    final
    CarService service;

    public CarRestController(CarService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Car>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Car> getById(@PathVariable("id") int id){
        Car result = service.getById(id);
        if(result==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @PostMapping()
    public ResponseEntity<Car> saveCar(@RequestBody Car car){
        service.saveCar(car);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") int id, @RequestBody Car car){

        Car result = service.Update(id, car);
        if(result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteCar(@PathVariable("id") int id){
        Car deletedCar = service.delete(id);
        if(deletedCar==null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }




}
