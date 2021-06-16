package com.example.demo.services;

import com.example.demo.contract.AccidentDto;
import com.example.demo.contract.CarDto;
import com.example.demo.model.Accident;
import com.example.demo.model.Car;
import com.example.demo.repositories.AccidentRepository;
import com.example.demo.repositories.CarRepository;
import com.github.dozermapper.core.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarDataService {

    private final CarRepository repository;
    private final AccidentRepository accidentRepository;
    private final Mapper mapper;

    public CarDataService(CarRepository repository, AccidentRepository accidentRepository,
                          Mapper mapper) {
        this.repository = repository;
        this.accidentRepository = accidentRepository;
        this.mapper = mapper;
    }

    public void save(CarDto carDto){
        repository.save(mapper.map(carDto, Car.class));
    }

    public CarDto getById(int id){
        Car car = repository.findById(id).orElse(null);
        if(car == null) return null;
        return mapper.map(car, CarDto.class);
    }

    public Car getByBadId(int id){
        Car car = repository.findById(id).orElse(null);
        if(car == null) return null;
        return car;
    }

    public List<CarDto> getAll(){
        List<CarDto> result =repository.findAll()
                .stream()
                .map(x->mapper.map(x, CarDto.class))
                .collect(Collectors.toList());
        return result;
    }

    public CarDto update(int id, CarDto carDto){
        Car car = repository.findById(id).orElse(null);
        if(car == null) return null;
        car.setModel(carDto.getModel());
        car.setRegistrationNumber(carDto.getRegistrationNumber());
        car.setMilleage(carDto.getMilleage());
        car.setHasAccidents(carDto.isHasAccidents());
        car.setPrice(carDto.getPrice());
        repository.save(car);
        return carDto;
    }

    public CarDto delete(int id){
        Car car = repository.findById(id).orElse(null);
        if(car == null) return null;
        repository.delete(car);
        return  mapper.map(car, CarDto.class);
    }

    public List<CarDto> getByModel(String name){
        return repository.getAllByModel(name)
                .stream()
                .map(x->mapper.map(x, CarDto.class))
                .collect(Collectors.toList());
    }

    public CarDto saveAccident(int id, AccidentDto accident){
        Car car = repository.findById(id).orElse(null);
        if(car == null) return null;
        Accident accidentToSave = mapper.map(accident, Accident.class);
        accidentToSave.setCar(car);
        car.getAccidents().add(accidentToSave);
        repository.save(car);
        accidentRepository.save(accidentToSave);
        return new CarDto();
    }

    public List<AccidentDto> getAccident(int id){
        Car car = repository.findById(id).orElse(null);
        if(car == null) return null;
        List<AccidentDto> result = car.getAccidents()
                .stream()
                .map(a->mapper.map(a, AccidentDto.class))
                .collect(Collectors.toList());
        return result;
    }

    public AccidentDto deleteAccident(int carId, int accidentId){
        Car car = repository.findById(carId).orElse(null);
        if (car == null) return null;
        Accident accident = car.getAccidents()
                .stream()
                .filter(a->a.getId()==accidentId)
                .findFirst()
                .orElse(null);
        if(accident == null) return null;
        accidentRepository.delete(accident);
        return  mapper.map(accident, AccidentDto.class);
    }

    public AccidentDto updateAccident(int carId, int accidentId, AccidentDto accidentDto){
        Accident accident = accidentRepository.findById(accidentId).orElse(null);
        if(accident == null) return null;
        mapper.map(accidentDto, accident);
        accident.setId(accidentId);
        accidentRepository.save(accident);
        return accidentDto;
    }

}