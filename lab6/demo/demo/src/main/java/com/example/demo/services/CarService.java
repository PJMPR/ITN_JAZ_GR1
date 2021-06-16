package com.example.demo.services;

import com.example.demo.contract.CarDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class CarService {
    private List<CarDto> db = new ArrayList<CarDto>();

    public List<CarDto> getAllCar(){
        return this.db;
    }

    public CarDto getByIdCar(int id){
        Optional<CarDto> result =  db.stream().filter(p->p.getID()==id).findFirst();
        if(result.isPresent())
            return result.get();
        return null;
    }

    public void saveCar(CarDto car){
        OptionalInt lastId = db.stream().map(p->p.getID()).mapToInt(x->x).max();
        if(!lastId.isPresent())
            car.setID(1);
        else car.setID(lastId.getAsInt()+1);
        db.add(car);
    }

    public CarDto Update(int id, CarDto car){
        CarDto result = getCarById(id);
        if (result == null) return null;
        result.setModel(car.getModel());
        result.setRegistrationNumber(car.getRegistrationNumber());
        result.setMilleage(car.getMilleage());
        result.setHasAccidents(car.isHasAccidents());
        result.setPrice(car.getPrice());
        return result;
    }

    public CarDto delete(int id){
        CarDto result = getCarById(id);
        if (result == null) return null;
        db.remove(result);
        return result;
    }

    private CarDto getCarById(int id2) {
        Optional<CarDto> fromList = db.stream().filter(p -> p.getID() == id2).findFirst();
        if (!fromList.isPresent()) return null;
        CarDto result = fromList.get();
        return result;
    }
}