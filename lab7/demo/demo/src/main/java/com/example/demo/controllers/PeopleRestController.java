package com.example.demo.controllers;

import com.example.demo.contract.AddressDto;
import com.example.demo.contract.PersonDto;
import com.example.demo.model.Address;
import com.example.demo.model.Person;
import com.example.demo.services.PeopleDataService;
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
    // /people/1/addresses
    @PostMapping("{id}/addresses")
    public ResponseEntity saveAddress(@PathVariable("id") int id, @RequestBody AddressDto address){
        PersonDto dto = dataService.saveAddress(id, address);
        if(dto==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}/addresses")
    public ResponseEntity<List<AddressDto>> getAddresses(@PathVariable("id") int id){
        List<AddressDto>  addresses = dataService.getAddresses(id);
        if(addresses==null)return ResponseEntity.notFound().build();
        return ResponseEntity.ok(addresses);
    }

    @DeleteMapping("{id}/addresses/{address_id}")
    public ResponseEntity deleteAddress(@PathVariable("id") int personId,
                                        @PathVariable("address_id") int addressId){
        AddressDto address = dataService.deleteAddress(personId, addressId);
        if(address==null)return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}/addresses/{address_id}")
    public ResponseEntity updateAddress(
            @PathVariable("id") int personId,
            @PathVariable("address_id") int addressId,
            @RequestBody AddressDto addressDto
        ){

        AddressDto address = dataService.updateAddress(personId, addressId, addressDto);
        if(address==null)return  ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

}
