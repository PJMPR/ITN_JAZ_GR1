package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class LoginMessages {
    String username;

    public void setUsername(String username) {
        this.username = username;
    }

    @Value("${method.welcome}") String welcome;
    public String welcome(){
        return welcome;
    }

    @Value("${method.provideMessage}") String provideMessage;
    public String getUsernameMessage(){
        return provideMessage;
    }

    @Value("${method.loggedAsMessage}") String loggedAsMessage;
    public String getLoggedAsMessage(){
        return loggedAsMessage + " " + username;
    }

}
