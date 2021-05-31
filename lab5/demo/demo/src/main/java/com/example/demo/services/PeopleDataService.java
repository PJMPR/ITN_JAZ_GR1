package com.example.demo.services;

import com.example.demo.contract.Person;
import com.example.demo.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleDataService {

    public PeopleDataService(PersonRepository repository) {
        this.repository = repository;
    }

    private final PersonRepository repository;

    public void save(Person person){
        repository.save(person);
    }

    public Person getById(int id){
        Person person = repository.findById(id).orElse(null);
        return person;
    }

    public List<Person> getAll(){
        List<Person> result = repository.findAll();
        return result;
    }

    public Person update(int id, Person person){
        Person person1 = repository.findById(id).orElse(null);
        if(person1==null)return null;
        person1.setSurname(person.getSurname());
        person1.setName(person.getName());
        person1.setAge(person.getAge());
        repository.save(person1);
        return person1;
    }

    public Person delete(int id){
        Person person = getById(id);
        if(person ==null) return null;
        repository.delete(person);
        return person;
    }

    public List<Person> getByName(String name){
        return repository.getAllByName(name);
    }

}