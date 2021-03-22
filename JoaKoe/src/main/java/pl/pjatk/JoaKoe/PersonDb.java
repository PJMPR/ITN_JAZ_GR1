package pl.pjatk.JoaKoe;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonDb {
	
	Person person;
	Person[] persons;
	int howManyPeople = 0;
	
	
	public void setHowMany() {
		this.howManyPeople += 1;
	}
	
    public PersonDb(Person person) {
    	setDb();
    }

    public Person[] getPersonArray(){
        return this.persons;
    }

    public void setDb(){
    	this.persons = new Person[1000];
    };

    public Person[] getDb(){
    	return this.persons;
    };
    
    public Person[] addPerson(Person person) {
    	if(howManyPeople>1000) {
    		Person[] newPersons = new Person[howManyPeople +1];
        	for(int i=0;i<howManyPeople;i++) {
        		newPersons[i] = persons[i];
        	}
        	
        	newPersons[persons.length] = person;
        	setHowMany();
        	return newPersons;
    	}
    	else {
    		persons[howManyPeople] =  person;
    		setHowMany();
    		return persons;
    	}
    }
}
