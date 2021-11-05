package com.example.springbootproject.controller;


import com.example.springbootproject.model.User;
import com.example.springbootproject.repo.UserRepository;
import com.example.springbootproject.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private MainService userService;

    @GetMapping(path = "/home")
    public String test(Model model){
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "/home";
    }

    @GetMapping(path = "/addUser")
    public ModelAndView createUser(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(new User());
        modelAndView.setViewName("/addUser");
        return modelAndView;
    }
    @PostMapping(value = "addUser")
    public ModelAndView addUser(User user){
        userService.saveUser(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(new User());
        modelAndView.setViewName("/addUser");
        return modelAndView;
    }
}
