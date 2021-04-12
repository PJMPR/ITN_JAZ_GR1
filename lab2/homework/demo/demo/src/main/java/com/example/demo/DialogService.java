package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class DialogService {

    private LoginMessages message;

    public DialogService (LoginMessages message){

        this.message = message;
    }

    public LoginMessages getLoginMessages() {

        return message;
    }
}
