package com.example.demo.controllers;

import com.example.demo.contract.Car;
import com.example.demo.services.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cars") //localhost:8080/cars
public class CarController {

    final CarService serviceCar;

    public CarController(CarService serviceCar){
        this.serviceCar = serviceCar;
    }

    @GetMapping()
    public ResponseEntity<List<Car>> getAllCar(){
        return ResponseEntity.ok(serviceCar.getAllCar());
    }

    @GetMapping("{id}")
    public ResponseEntity<Car> getByIdCar(@PathVariable("id") int id){
        Car result = serviceCar.getByIdCar(id);
        if(result==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @PostMapping()
    public ResponseEntity<Car> saveCar(@RequestBody Car car){
        serviceCar.saveCar(car);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") int id, @RequestBody Car car){

        Car result = serviceCar.Update(id, car);
        if(result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteCar(@PathVariable("id") int id){
        Car deletedCar = serviceCar.delete(id);
        if(deletedCar==null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

}