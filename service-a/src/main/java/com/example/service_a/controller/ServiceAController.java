package com.example.service_a.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceAController {

    private final RestTemplate restTemplate;

    public ServiceAController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/call-b")
    public String callServiceB() {
        // Uses service name instead of IP:PORT
        String response = restTemplate.getForObject("http://service-b/hello", String.class);
        return "Service A → " + response;
    }
}
