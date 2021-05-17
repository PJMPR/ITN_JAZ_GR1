package com.example.demo.services;

import com.example.demo.contract.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class PeopleService {

    private List<Person> db = new ArrayList<Person>();

    public List<Person> getAll(){
        return this.db;
    }

    public Person getById(int id){
        Optional<Person> result =  db.stream().filter(p->p.getID()==id).findFirst();
        if(result.isPresent())
            return result.get();
        return null;
    }

    public void savePerson(Person person){
        OptionalInt lastId = db.stream().map(p->p.getID()).mapToInt(x->x).max();
        if(!lastId.isPresent())
            person.setID(1);
        else person.setID(lastId.getAsInt()+1);
        db.add(person);
    }

    public Person Update(int id, Person person){
        Person result = getPersonById(id);
        if (result == null) return null;
        result.setSurname(person.getSurname());
        result.setName(person.getName());
        result.setAge(person.getAge());
        return result;
    }

    public Person delete(int id){
        Person result = getPersonById(id);
        if (result == null) return null;
        db.remove(result);
        return result;
    }

    private Person getPersonById(int id2) {
        Optional<Person> fromList = db.stream().filter(p -> p.getID() == id2).findFirst();
        if (!fromList.isPresent()) return null;
        Person result = fromList.get();
        return result;
    }
}