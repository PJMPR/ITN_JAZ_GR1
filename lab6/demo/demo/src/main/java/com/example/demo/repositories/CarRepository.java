package com.example.demo.repositories;

import com.example.demo.contract.CarDto;
import com.example.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    public List<Car> getAllByModel(String name);
}