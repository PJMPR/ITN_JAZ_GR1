package com.example.demo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Persondb {
    private Person[] personArray;

    public Persondb(){
        personArray = new Person[1000];
    }

    public void addToPersonArray(Person person){
        personArray[0] = person;
    }
}
