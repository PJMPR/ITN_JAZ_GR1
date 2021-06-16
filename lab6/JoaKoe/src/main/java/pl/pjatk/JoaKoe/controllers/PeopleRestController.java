package pl.pjatk.JoaKoe.controllers;


import pl.pjatk.JoaKoe.contract.AdressDto;
import pl.pjatk.JoaKoe.contract.PersonDto;
import pl.pjatk.JoaKoe.model.Adress;
import pl.pjatk.JoaKoe.model.Person;
import pl.pjatk.JoaKoe.services.PeopleDataService;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("people") // localhost:8080/people
public class PeopleRestController {


    final private PeopleDataService dataService;


    public PeopleRestController( PeopleDataService dataService)
    {
        this.dataService =dataService;
    }

    @GetMapping()
    public ResponseEntity<List<PersonDto>> getAll(@RequestParam(value = "name", required = false) @DefaultValue("") String name){

        if(name==null || name == "")
            return ResponseEntity.ok(dataService.getAll());
        return ResponseEntity.ok(dataService.getByName(name));
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonDto> getById(@PathVariable("id") int id){
        PersonDto result = dataService.getById(id);
        if(result==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @PostMapping()
    public ResponseEntity<PersonDto> savePerson(@RequestBody PersonDto personDto){

        dataService.save(personDto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<PersonDto> updatePerson(@PathVariable("id") int id, @RequestBody PersonDto personDto){

        PersonDto result = dataService.update(id, personDto);
        if(result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePerson(@PathVariable("id") int id){
        PersonDto deletedPersonDto = dataService.delete(id);
        if(deletedPersonDto ==null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
    // /people/1/adresses
    @PostMapping("{id}/adresses")
    public ResponseEntity saveAdress(@PathVariable("id") int id, @RequestBody AdressDto adress){
        PersonDto dto = dataService.saveAdress(id, adress);
        if(dto==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}/adresses")
    public ResponseEntity getAdresses(@PathVariable("id") int id){
        List<AdressDto>  adresses = dataService.getAdresses(id);
        if(adresses==null)return ResponseEntity.notFound().build();
        return ResponseEntity.ok(adresses);
    }

    @DeleteMapping("{id}/adresses/{adress_id}")
    public ResponseEntity deleteAdress(@PathVariable("id") int personId,
                                        @PathVariable("adress_id") int adressId){
        AdressDto adress = dataService.deleteAdress(personId, adressId);
        if(adress==null)return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}/adresses/{adress_id}")
    public ResponseEntity updateAdress(
            @PathVariable("id") int personId,
            @PathVariable("adress_id") int adressId,
            @RequestBody AdressDto adressDto
        ){

        AdressDto adress = dataService.updateAdress(personId, adressId, adressDto);
        if(adress==null)return  ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

}
