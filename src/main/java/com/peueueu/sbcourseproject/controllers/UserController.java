package com.peueueu.sbcourseproject.controllers;

import com.peueueu.sbcourseproject.model.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public List<User> getUsers(@RequestParam(name = "id", defaultValue = "1") Integer id) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "John", "Doe"));
        users.add(new User(2, "Jane", "Doe"));
        users.add(new User(3, "Janis", "Doe"));
        users.add(new User(4, "James", "Doe"));
        users.add(new User(5, "Doris", "Doe"));
        if(id != null) {
            return users.stream().filter(u -> u.getId() == id).toList();
        }
        return users;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getSingleUser(@PathVariable int id) {
        return new User(id, "Anders Heljsberg", "123.456.789-00");
    }
}
