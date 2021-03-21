package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class PersonDb {

    public Person[] PersonArray = new Person[1000];


    public Person[] getPersonArray() {
        return PersonArray;
    }

    public void Add(Person person) {

        PersonArray[0] = person;

    }
}
