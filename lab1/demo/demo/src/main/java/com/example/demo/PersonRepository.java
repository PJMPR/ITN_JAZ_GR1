package com.example.demo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class PersonRepository{
    private PersonDb personDb;

    public PersonRepository(PersonDb personDb){
        this.personDb = personDb;
    }

    public void save(Person person){
        PersonDb.addToArray(person);
    }

    public PersonDb getDb(){
        return personDb;
    }
}