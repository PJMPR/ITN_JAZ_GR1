package com.example.demo.controllers;

import com.example.demo.contract.AccidentDto;
import com.example.demo.services.CarDataService;
import com.example.demo.contract.CarDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cars") //localhost:8080/cars
public class CarController {

    final private CarDataService carDataService;

    public CarController(CarDataService carDataService){
        this.carDataService = carDataService;
    }

    @GetMapping()
    public ResponseEntity<List<CarDto>> getAllCar(){
        return ResponseEntity.ok(carDataService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<CarDto> getByIdCar(@PathVariable("id") int id){
        CarDto result = carDataService.getById(id);
        if(result==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @PostMapping()
    public ResponseEntity<CarDto> saveCar(@RequestBody CarDto carDto){
        carDataService.save(carDto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<CarDto> updateCar(@PathVariable("id") int id, @RequestBody CarDto carDto){

        CarDto result = carDataService.update(id, carDto);
        if(result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteCar(@PathVariable("id") int id){
        CarDto deletedCar = carDataService.delete(id);
        if(deletedCar==null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
    @PostMapping("{id}/accidents")
    public ResponseEntity saveAccident(@PathVariable("id") int id,
                                       @RequestBody AccidentDto accident){
        CarDto carDto = carDataService.saveAccident(id, accident);
        if(carDto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}/accidents")
    public ResponseEntity getAccident(@PathVariable("id") int id){
        List<AccidentDto> accidentDtos = carDataService.getAccident(id);
        if(accidentDtos == null) return  ResponseEntity.notFound().build();
        return ResponseEntity.ok(accidentDtos);
    }

    @DeleteMapping("{id}/accidents/{accident_id}")
    public ResponseEntity deleteAccident(@PathVariable("id") int carId,
                                         @PathVariable("accident_id") int accidentId){
        AccidentDto accidentDto = carDataService.deleteAccident(carId, accidentId);
        if(accidentDto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}/accidents/{accident_id")
    public ResponseEntity updateAccident(
            @PathVariable("id") int carId,
            @PathVariable("accident_id") int accidentId,
            @RequestBody AccidentDto accidentDto
    ){
        AccidentDto accident = carDataService.updateAccident(carId, accidentId, accidentDto);
        if(accident == null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }


}