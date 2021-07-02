package pl.pjatk.JoaKoe.services;

import pl.pjatk.JoaKoe.contract.AdressDto;
import pl.pjatk.JoaKoe.contract.PersonDto;
import pl.pjatk.JoaKoe.model.Adress;
import pl.pjatk.JoaKoe.model.Person;
import pl.pjatk.JoaKoe.repositories.AdressRepository;
import pl.pjatk.JoaKoe.repositories.PersonRepository;
import org.springframework.stereotype.Service;
import com.github.dozermapper.core.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeopleDataService {


    private final PersonRepository repository;
    private final AdressRepository adressRepository;
    private final Mapper mapper;

    public PeopleDataService(PersonRepository repository,
                             AdressRepository adressRepository, Mapper mapper)
    {
        this.adressRepository = adressRepository;
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

    public PersonDto saveAdress(int id, AdressDto adress) {
        Person person = repository.findById(id).orElse(null);
        if(person==null) return null;
        Adress adressToSave = mapper.map(adress, Adress.class);
        adressToSave.setPerson(person);
        person.getAdresses().add(adressToSave);
        repository.save(person);
        adressRepository.save(adressToSave);
        return new PersonDto();
    }

    public List<AdressDto> getAdresses(int id) {

        Person person = repository.findById(id).orElse(null);
        if(person==null) return null;
        List<AdressDto> result = person.getAdresses()
                .stream()
                .map(a->mapper.map(a, AdressDto.class))
                .collect(Collectors.toList());
        return result;
    }

    public AdressDto deleteAdress(int personId, int adressId) {
        Person person = repository.findById(personId).orElse(null);
        if(person==null) return null;
        Adress adress = person.getAdresses()
                .stream()
                .filter(a->a.getId()==adressId)
                .findFirst()
                .orElse(null);
        if(adress==null)return null;
        adressRepository.delete(adress);
        return mapper.map(adress, AdressDto.class);

    }

    public AdressDto updateAdress(int personId, int adressId, AdressDto adressDto) {
        Adress adress = adressRepository.findById(adressId).orElse(null);
        if(adress == null) return null;
        mapper.map(adressDto, adress);
        adress.setId(adressId);
        adressRepository.save(adress);
        return adressDto;
    }
}
