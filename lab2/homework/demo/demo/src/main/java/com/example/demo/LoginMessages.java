package com.example.demo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LoginMessages {

    String user;

    public LoginMessages loginMessages() {
        return new LoginMessages();
    }

    @Value("${message.welcome}") String welcome;
    public String welcome() {
        return welcome;
    }

    @Value("${message.provideUsername}") String provideUsername;
    public String getUsernameMessage() {
        return provideUsername;
    }

    public void setUsername(String username) {
        user = username;

    }

    @Value("${message.loggedAsMessage}") String loggedAsMessage;
    public String getLoggedAsMessage() {
        return loggedAsMessage + " " + user;
    }
}
