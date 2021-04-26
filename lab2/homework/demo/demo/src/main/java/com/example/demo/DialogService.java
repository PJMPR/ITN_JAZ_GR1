package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class DialogService {
    private LoginMessages messages;

    public DialogService(LoginMessages m) {
        messages = m;
    }

    public LoginMessages getLoginMessages(){
        return messages;
    }
}