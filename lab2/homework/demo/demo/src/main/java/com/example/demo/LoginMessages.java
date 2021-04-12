package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginMessages {
    private String username;
    public String welcome() {
        return "Welcome";
    }

    public String getUsernameMessage() {
        return "podaj nazwe uzytkownika:";
    }

    public void setUsername(String username) {
        this.username=username;
    }

    public String getLoggedAsMessage() {
        return "Zalogowany jako "+ this.username;
    }
}
