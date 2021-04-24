package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoginMessages {

    @Value("${msg.welcome}")
    String welcome;
    @Value("${msg.provideusername}")
    String usernameMessage;
    String username;
    @Value("${msg.loggedas}")
    String loggedAsMessage;

    public String welcome() {
        return welcome;
    }

    public String getUsernameMessage() {
        return usernameMessage;
    }

    public void setUsername(String admin) {
        username=admin;
    }

    public String getLoggedAsMessage() {
        return loggedAsMessage+" "+username;
    }
}
