package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginMessages {

    String username;

    @Value("${message.welcome}") String welcome;
    public String welcome() {
        return welcome;
    }
    @Value("${message.provideUsername}") String provideUsername;
    public String getUsernameMessage() {
        return provideUsername;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Value("${message.loggedAsMessage}") String loggedAsMessage;
    public String getLoggedAsMessage() {
        return loggedAsMessage + " " + username;
    }
}
