package com.example.demo.services;

import com.example.demo.contract.Car;
import com.example.demo.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarDataService {

    public CarDataService(CarRepository repository) {
        this.repository = repository;
    }

    private final CarRepository repository;

    public void save(Car car){
        repository.save(car);
    }

    public Car getById(int id){
        Car car = repository.findById(id).orElse(null);
        return car;
    }

    public List<Car> getAll(){
        List<Car> result = repository.findAll();
        return result;
    }

    public Car update(int id, Car car){
        Car car1 = repository.findById(id).orElse(null);
        if(car1==null)return null;
        car1.setModel(car.getModel());
        car1.setRegistrationNumber(car1.getRegistrationNumber());
        car1.setMilleage(car1.getMilleage());
        car1.setHasAccidents(car1.isHasAccidents());
        car1.setPrice(car1.getPrice());
        repository.save(car1);
        return car1;
    }

    public Car delete(int id){
        Car car = getById(id);
        if(car ==null) return null;
        repository.delete(car);
        return car;
    }

    public List<Car> getByName(String name){
        return repository.getAllByName(name);
    }

}
