package com.example.demo.repositories;

import com.example.demo.contract.CarDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<CarDto, Integer> {
    public List<CarDto> getAllByModel(String name);
}