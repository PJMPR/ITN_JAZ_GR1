package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class DialogService {
    private final LoginMessages message;

    public DialogService(LoginMessage message) {
        this.message = messages;
    }

    public LoginMessages getLoginMessages() {
        return message;
    }
}
