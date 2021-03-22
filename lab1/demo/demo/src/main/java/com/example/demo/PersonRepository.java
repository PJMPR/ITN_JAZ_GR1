package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class PersonRepository {

    public PersonDb db;
    public PersonRepository(PersonDb personDb) {
        this.db = personDb;
    }

    public void save(Person person) {
        db.add(person);
    }

    public PersonDb getDb() {
        return db;
    }
}
