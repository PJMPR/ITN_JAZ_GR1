package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

//@Component
public class ThirdComponent {

    //ApplicationContext context;
    //public ThirdComponent(ApplicationContext context) {
    //    this.context=context;
    //}

    FirstComponent first;
    SecondComponent second;

    public ThirdComponent(FirstComponent first, SecondComponent second) {
        this.first = first;
        this.second = second;
    }

    public void SayHi(){

        first.printName();
        second.printName();
        System.out.println("Hi!");
    }
}
