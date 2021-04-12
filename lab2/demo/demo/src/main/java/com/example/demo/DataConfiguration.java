package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataConfiguration {

    @Bean
    public DbContext dbContext(
            @Value("${database.mysql.url}") String url,
                               @Value("${database.mysql.user}") String username,
                               @Value("${database.mysql.password}") String password
                               ){
        return new DbContext(url,username,password);
    }

    @Bean
    public List<String> defaultData(){
        List<String> result = new ArrayList<>();
        result.add("test");
        result.add("test1");
        return result;
    }

}
