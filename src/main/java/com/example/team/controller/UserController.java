package com.example.team.controller;

import com.example.team.entities.User;
import com.example.team.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return this.userService.createUser(user);
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        return this.userService.deleteUser(id);
    }
}

