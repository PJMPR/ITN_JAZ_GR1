package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class PersonDb {

    private Person[] personArray;

    {
        personArray = new Person[1000];
    }


    public Person[] getPersonArray() {
        return personArray;
    }

    public void Add(Person person) {

        personArray[0] = person;

    }
}