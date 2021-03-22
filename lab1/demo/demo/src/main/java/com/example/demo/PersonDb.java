package com.example.demo;

import lombok.Data;
import org.springframework.stereotype.Component;
import java.lang.reflect.Array;

@Data
@Component
public class PersonDb{
    private Person[] personArray;

    public PersonDb(){
        personArray = new Person[1000];
    }

    public void addToArray(Person person){
        personArray[0] = person;
    }
}