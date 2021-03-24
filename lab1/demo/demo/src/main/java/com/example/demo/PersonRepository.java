package com.example.demo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class PersonRepository {

    private Persondb persondb;


    public PersonRepository(Persondb persondb) {
        this.persondb = persondb;
    }

    public void save(Person person){
        persondb.addToPersonArray(person);
    }

    public Persondb getDb(){
        return persondb;
    }

}
