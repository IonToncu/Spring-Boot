package com.example.springbootproject.service;

import com.example.springbootproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springbootproject.repo.UserRepository;

import java.util.List;

@Service
public class MainService {
    private UserRepository userRepository;

    @Autowired
    public MainService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
    public List<User> getAll(){
        return userRepository.getAllBy();
    }
}
