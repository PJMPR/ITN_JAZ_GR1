package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class PersonDb {

    public PersonDb() {

    }

    public Person[] personArray = new Person[1000];

    public Person[] getPersonArray() {
        return personArray;
    }

    public void add(Person person) {
        personArray[0] = person;
    }
}
