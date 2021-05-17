package com.example.demo.services;


import com.example.demo.contract.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class CarService {

    private List<Car> db = new ArrayList<Car>();
    public List<Car> getAll(){
        return this.db;
    }

    public Car getById(int id){
        Optional<Car> result =  db.stream().filter(p->p.getID()==id).findFirst();
        if(result.isPresent())
            return result.get();
        return null;
    }

    public void saveCar(Car car){
        OptionalInt lastId = db.stream().map(p->p.getID()).mapToInt(x->x).max();
        if(!lastId.isPresent())
            car.setID(1);
        else car.setID(lastId.getAsInt()+1);
        db.add(car);
    }

    public Car Update(int id, Car car){
        Car result = getCarById(id);
        if (result == null) return null;
        result.setModel(car.getModel());
        result.setRegistrationNumber(car.getRegistrationNumber());
        result.setMilleage(car.getMilleage());
        result.setHasAccidents(car.isHasAccidents());
        result.setPrice(car.getPrice());
        return result;
    }

    public Car delete(int id){
        Car result = getCarById(id);
        if (result == null) return null;
        db.remove(result);
        return result;
    }

    private Car getCarById(int id2) {
        Optional<Car> fromList = db.stream().filter(p -> p.getID() == id2).findFirst();
        if (!fromList.isPresent()) return null;
        Car result = fromList.get();
        return result;
    }
}
