package com.example.demo;

import org.springframework.beans.factory.annotation.Value;

public class DbContext {

    @Value("${database.mysql.url}")
    private String url;
    @Value("${database.mysql.user}")
    private String username;
    private String password;
    @Value("${database.mysql.timeout:60}")
    private int timeout;

    public DbContext() {
    }

    public DbContext(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        System.out.println(url);

    }

    public String getConnectionString(){
        return "server=" + url+
                ";user=" +
                username +
                ";password=" +
                password +
                ";timeout=" +
                timeout;
    }
}
