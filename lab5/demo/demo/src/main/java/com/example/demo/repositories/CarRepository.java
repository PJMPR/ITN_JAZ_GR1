package com.example.demo.repositories;

import com.example.demo.contract.Car;
import com.example.demo.contract.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    public List<Car> getAllByModel(String name);
}
