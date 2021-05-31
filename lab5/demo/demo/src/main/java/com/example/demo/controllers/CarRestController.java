package com.example.demo.controllers;

import com.example.demo.contract.Car;
import com.example.demo.services.CarDataService;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("car")
public class CarRestController {


    final private CarDataService dataService;


    public CarRestController( CarDataService dataService)
    {
        this.dataService =dataService;
    }

    @GetMapping()
    public ResponseEntity<List<Car>> getAll(@RequestParam("model") @DefaultValue("") String model){

        if(model==null || model == "")
            return ResponseEntity.ok(dataService.getAll());
        return ResponseEntity.ok(dataService.getByModel(model));
    }

    @GetMapping("{id}")
    public ResponseEntity<Car> getById(@PathVariable("id") int id){
        Car result = dataService.getById(id);
        if(result==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @PostMapping()
    public ResponseEntity<Car> saveCar(@RequestBody Car car){

        dataService.save(car);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") int id, @RequestBody Car car){

        Car result = dataService.update(id, car);
        if(result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteCar(@PathVariable("id") int id){
        Car deletedCar = dataService.delete(id);
        if(deletedCar==null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

}
