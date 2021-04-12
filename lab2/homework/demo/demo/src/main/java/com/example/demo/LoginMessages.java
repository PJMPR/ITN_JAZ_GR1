package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class LoginMessages {

    @Value("${message.message}")
    private String message;
    private String Username;
    @Value("${message.UsernameMessage}")
    private String UsernameMessage;// = "podaj nazwe uzytkownika:" ;
    @Value("${message.LoggedAsMessage}")
    private String LoggedAsMessage ;//= "Zalogowany jako ";


    public String getUsernameMessage() {
        return UsernameMessage;
    }

    public void setUsernameMessage(String usernameMessage) {
        UsernameMessage = usernameMessage;
    }

    public String getLoggedAsMessage() {
        return LoggedAsMessage + getUsername();
    }

    public void setLoggedAsMessage(String loggedAsMessage) {
        LoggedAsMessage = loggedAsMessage;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }


    public String welcome()
    {
        return message;
    }

   /* public String getUsernameMessage()
    {
        return "podaj nazwe uzytkownika:";
    }

    public String getLoggedAsMessage()
    {
        return "Zalogowany jako " + getUsername();
    }
*/

}


