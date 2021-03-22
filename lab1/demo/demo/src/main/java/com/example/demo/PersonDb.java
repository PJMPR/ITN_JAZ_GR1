package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class PersonDb {

        public Person[] persons = new Person[1000];

        public void Add(Person person) {
            persons[0] = person;
        }

        public Person[] getPersonArray() {
            return persons;
        }
}
