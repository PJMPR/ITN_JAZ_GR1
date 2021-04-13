package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class DialogService {

    private final LoginMessages messages;

    public DialogService(LoginMessages messages) {
        this.messages = messages;
    }

    public LoginMessages getLoginMessages() {
        return messages;
    }
}
