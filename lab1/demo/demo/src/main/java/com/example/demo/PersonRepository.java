package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PersonRepository {


    public PersonDb Db;

    public PersonRepository(PersonDb personDb){
        this.Db = personDb;

    }

    public void save(Person person) {

        Db.Add(person);
    }

    public PersonDb getDb() {
        return Db;
    }
}
