package com.example.demo;

import org.springframework.stereotype.Component;

//@Component
public class SecondComponent {
    public SecondComponent(FirstComponent first) {
    }

    public void printName(){

        System.out.println("Second");
    }
}
