package com.example.service_b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceBController {

    private final ServletWebServerApplicationContext serverAppContext;

    @Autowired
    public ServiceBController(ServletWebServerApplicationContext serverAppContext) {
        this.serverAppContext = serverAppContext;
    }

    @GetMapping("/hello")
    public String hello() {
        int actualPort = serverAppContext.getWebServer().getPort();
        return "Hello from Service B on port " + actualPort;
    }
}
