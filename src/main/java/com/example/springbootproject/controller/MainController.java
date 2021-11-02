package com.example.springbootproject.controller;


import com.example.springbootproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/")
    public String test(){

        return "/home";
    }
}
