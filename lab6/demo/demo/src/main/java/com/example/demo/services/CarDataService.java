package com.example.demo.services;

import com.example.demo.contract.CarDto;
import com.example.demo.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarDataService {

    public CarDataService(CarRepository repository) {
        this.repository = repository;
    }

    private final CarRepository repository;

    public void save(CarDto car){
        repository.save(car);
    }

    public CarDto getById(int id){
        CarDto car = repository.findById(id).orElse(null);
        return car;
    }

    public List<CarDto> getAll(){
        List<CarDto> resultCar = repository.findAll();
        return resultCar;
    }

    public CarDto update(int id, CarDto car){
        CarDto car1 = repository.findById(id).orElse(null);
        if(car1==null)return null;
        car1.setModel(car.getModel());
        car1.setRegistrationNumber(car1.getRegistrationNumber());
        car1.setMilleage(car1.getMilleage());
        car1.setHasAccidents(car1.isHasAccidents());
        car1.setPrice(car1.getPrice());
        repository.save(car1);
        return car1;
    }

    public CarDto delete(int id){
        CarDto car = getById(id);
        if(car ==null) return null;
        repository.delete(car);
        return car;
    }

    public List<CarDto> getByModel(String name){
        return repository.getAllByModel(name);
    }

}