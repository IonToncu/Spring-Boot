package com.example.springbootproject.controller;

import com.example.springbootproject.model.Product;
import com.example.springbootproject.model.User;
import com.example.springbootproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/user")
    List<User> allUsers(){
        return userService.findAll();
    }

    @PostMapping("/user")
    User newUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User user, @PathVariable Long id){
        return userService.updateUser(user, id);
    }
    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
