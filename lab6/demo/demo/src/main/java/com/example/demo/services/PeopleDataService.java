package com.example.demo.services;

import com.example.demo.contract.AddressDto;
import com.example.demo.contract.PersonDto;
import com.example.demo.model.Address;
import com.example.demo.model.Person;
import com.example.demo.repositories.AddressRepository;
import com.example.demo.repositories.PersonRepository;
import com.github.dozermapper.core.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeopleDataService {


    private final PersonRepository repository;
    private final AddressRepository addressRepository;
    private final Mapper mapper;

    public PeopleDataService(PersonRepository repository,
                             AddressRepository addressRepository, Mapper mapper
    ) {
        this.addressRepository = addressRepository;
        this.mapper=mapper;
        this.repository = repository;
    }


    public void save(PersonDto personDto){

        repository.save(mapper.map(personDto, Person.class));
    }

    public PersonDto getById(int id){
        Person person = repository.findById(id).orElse(null);
        if(person==null)return null;
        return mapper.map(person, PersonDto.class);
    }

    public Person getByIdBad(int id){
        Person person = repository.findById(id).orElse(null);
        if(person==null)return null;
        return person;
    }

    public List<PersonDto> getAll(){
        List<PersonDto> result = repository.findAll()
                .stream()
                .map(x->mapper.map(x, PersonDto.class))
                .collect(Collectors.toList());
        return result;
    }

    public PersonDto update(int id, PersonDto personDto){
        Person person = repository.findById(id).orElse(null);
        if(person ==null)return null;
        person.setSurname(personDto.getSurname());
        person.setName(personDto.getName());
        person.setAge(personDto.getAge());
        repository.save(person);
        return personDto;
    }

    public PersonDto delete(int id){
        Person person = repository.findById(id).orElse(null);
        if(person ==null)return null;
        repository.delete(person);
        return mapper.map(person, PersonDto.class);
    }

    public List<PersonDto> getByName(String name){

        return repository.getAllByName(name)
                .stream()
                .map(x->mapper.map(x, PersonDto.class))
                .collect(Collectors.toList());
    }

    public PersonDto saveAddress(int id, AddressDto address) {
        Person person = repository.findById(id).orElse(null);
        if(person==null) return null;
        Address addressToSave = mapper.map(address, Address.class);
        addressToSave.setPerson(person);
        person.getAddresses().add(addressToSave);
        repository.save(person);
        addressRepository.save(addressToSave);
        return new PersonDto();
    }

    public List<AddressDto> getAddresses(int id) {

        Person person = repository.findById(id).orElse(null);
        if(person==null) return null;
        List<AddressDto> result = person.getAddresses()
                .stream()
                .map(a->mapper.map(a, AddressDto.class))
                .collect(Collectors.toList());
        return result;
    }

    public AddressDto deleteAddress(int personId, int addressId) {
        Person person = repository.findById(personId).orElse(null);
        if(person==null) return null;
        Address address = person.getAddresses()
                .stream()
                .filter(a->a.getId()==addressId)
                .findFirst()
                .orElse(null);
        if(address==null)return null;
        addressRepository.delete(address);
        return mapper.map(address, AddressDto.class);

    }

    public AddressDto updateAddress(int personId, int addressId, AddressDto address) {
        Person person = repository.findById(personId).orElse(null);
        if(person==null)return null;
        Address addressToUpdate = addressRepository.findById(addressId).orElse(null);
        if(addressToUpdate==null)return null;
        mapper.map(address, addressToUpdate);
        addressToUpdate.setId(addressId);
        addressRepository.save(addressToUpdate);
        return address;
    }
}
