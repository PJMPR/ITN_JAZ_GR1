package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;


@Component
public class DialogService {

   private final LoginMessages message;

    public DialogService(LoginMessages message) {
        this.message = message;
    }
    public LoginMessages getLoginMessages() {

        return message;
    }
}
