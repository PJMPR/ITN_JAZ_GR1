package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DialogService {

    private final LoginMessages messages;

    //    @Bean
    public DialogService(LoginMessages messages) {this.messages = messages;}

    public LoginMessages getLoginMessages() {return messages;}
}
