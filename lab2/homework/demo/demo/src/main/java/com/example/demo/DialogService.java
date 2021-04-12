package com.example.demo;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DialogService {

    public LoginMessages messages;

    public DialogService(LoginMessages messages) {
        this.messages = messages;
    }

    public LoginMessages getLoginMessages() {
        return messages;
    }
}
