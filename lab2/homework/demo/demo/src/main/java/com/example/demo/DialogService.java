package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DialogService {

    private final LoginMessages message;

    public DialogService (LoginMessages message){

        this.message = message;
    }

    public LoginMessages getLoginMessages() {

        return message;
    }
}
