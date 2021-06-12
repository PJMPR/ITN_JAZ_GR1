package com.example.demo.services;

import com.example.demo.contract.PersonDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class PeopleService {

    private List<PersonDto> db = new ArrayList<PersonDto>();

    public List<PersonDto> getAll(){
        return this.db;
    }

    public PersonDto getById(int id){
      Optional<PersonDto> result =  db.stream().filter(p->p.getID()==id).findFirst();
      if(result.isPresent())
          return result.get();
      return null;
    }

    public void savePerson(PersonDto personDto){
        OptionalInt lastId = db.stream().map(p->p.getID()).mapToInt(x->x).max();
        if(!lastId.isPresent())
            personDto.setID(1);
        else personDto.setID(lastId.getAsInt()+1);
        db.add(personDto);
    }

    public PersonDto Update(int id, PersonDto personDto){
        PersonDto result = getPersonById(id);
        if (result == null) return null;
        result.setSurname(personDto.getSurname());
        result.setName(personDto.getName());
        result.setAge(personDto.getAge());
        return result;
    }

    public PersonDto delete(int id){
        PersonDto result = getPersonById(id);
        if (result == null) return null;
        db.remove(result);
        return result;
    }

    private PersonDto getPersonById(int id2) {
        Optional<PersonDto> fromList = db.stream().filter(p -> p.getID() == id2).findFirst();
        if (!fromList.isPresent()) return null;
        PersonDto result = fromList.get();
        return result;
    }
}
