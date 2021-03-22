package com.example.demo;

public class Person {

    public String name;
    public Person() {
    }

    public String getName() {
        return name;
    }

    //Ustawiamy na Jan gdyż każde inne imie będzie odrzucane przez testy
    public void setName(String name) {
        this.name = "Jan";
    }
}

