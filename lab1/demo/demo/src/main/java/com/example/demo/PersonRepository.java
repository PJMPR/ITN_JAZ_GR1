package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class PersonRepository {

    public PersonDb personDb;

    public PersonRepository(PersonDb personDb){
        this.personDb = personDb;
    }

    public void save(Person person){
        personDb.Add(person);
    }

    public PersonDb getDb(){
        return personDb;
    }

}
