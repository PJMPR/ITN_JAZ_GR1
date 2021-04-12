package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DialogService {

    @Bean
    public void DialogServiceA() {}

    public LoginMessages getLoginMessages() {return new LoginMessages();}
}
