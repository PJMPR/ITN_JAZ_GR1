package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoginMessages {
    String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public LoginMessages loginMessages(){
        return new LoginMessages();
    }

    @Value("${$database.mysql.method.welcome}") String welcome;
    public String welcome(){
        return welcome;
    }

    @Value("${$database.mysql.method.provideMessage}") String provideMessage;
    public String getUsernameMessage(){
        return provideMessage;
    }

    @Value("${$database.mysql.method.loggedAsMessage}") String loggedAsMessage;
    public String getLoggedAsMessage(){
        return loggedAsMessage + "" + username;
    }

}
