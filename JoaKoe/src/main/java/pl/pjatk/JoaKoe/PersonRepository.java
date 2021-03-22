package pl.pjatk.JoaKoe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonRepository {
	
	Person person;
	PersonDb persons;
	
	public PersonRepository(Person person, PersonDb persons) {
		this.person = person;
		this.persons = persons;
	}
	
	public void save(Person person) {
		persons.persons = persons.addPerson(person);
	}

	public void getDb() {
		for(int i=0;i < persons.persons.length ;i++) {
			System.out.println(persons.persons[i].getName());
		}
		
	}
	
}
