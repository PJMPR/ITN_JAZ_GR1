package com.example.demo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class PersonRepository {
    private Persondb persondb;

    public PersonRepository(Persondb persondb) {
        this.persondb = persondb;
    }

    public void save(Person person){
        persondb.addToArray(person);
    }

    public Persondb getDb(){
        return persondb;
    }
}
