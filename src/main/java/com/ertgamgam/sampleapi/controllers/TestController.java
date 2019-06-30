package com.ertgamgam.sampleapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @Autowired
    Environment env;

    @GetMapping(path = {"/hello"})
    public ResponseEntity<String> Hello() {
        String environmentName = env.getProperty("environment.name");
        return (new ResponseEntity(environmentName, HttpStatus.OK));
    }

    @PostMapping(path = {"/hasmap"})
    public ResponseEntity TestHaspMap(@RequestBody HashMap hash) {

        return (new ResponseEntity(HttpStatus.OK));
    }
}
