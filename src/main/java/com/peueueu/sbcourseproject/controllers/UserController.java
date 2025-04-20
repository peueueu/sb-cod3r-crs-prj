package com.peueueu.sbcourseproject.controllers;

import com.peueueu.sbcourseproject.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/any")
    @ResponseStatus(HttpStatus.OK)
    public User getSingleUser() {
        return new User(2840, "Anders Heljsberg", "123.456.789-00");
    }
}
