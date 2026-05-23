package com.bajaj.bfhl.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller to handle the root landing path GET / to guide developers and prevent NoResourceFoundException.
 */
@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getHome() {
        Map<String, Object> response = new HashMap<>();
        response.put("is_success", true);
        response.put("message", "Bajaj Finserv Health Backend Challenge API is fully active and running!");
        
        Map<String, String> endpoints = new HashMap<>();
        endpoints.put("GET /bfhl", "Retrieve status/operation code");
        endpoints.put("POST /bfhl", "Classify data array into separated numbers and alphabets");
        
        response.put("endpoints", endpoints);
        response.put("developer", "Naitik");
        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
