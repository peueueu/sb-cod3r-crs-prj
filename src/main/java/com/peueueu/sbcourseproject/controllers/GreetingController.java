package com.peueueu.sbcourseproject.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String greeting(){
        return "Hello There!";
    }
}
