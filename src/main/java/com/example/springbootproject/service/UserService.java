package com.example.springbootproject.service;

import com.example.springbootproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springbootproject.repo.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.getUserById(id);
    }

    public User addUser(User user) {//todo throw exception if exist already this userName
        if(userRepository.getUserByUserName(user.getUserName()) == null){
            return userRepository.save(user);
        }
        return user;
    }

    public User updateUser(User user, Long id) {
        User oldUser;
        if((oldUser = findById(id)) != null){
            if(user.getUserName().length() > 0)
                oldUser.setUserName(user.getUserName());
            if(user.getAge() > 0)
                oldUser.setAge(user.getAge());
            return oldUser;
        }
        return null;
    }

    public void deleteUser(Long id) {
        User user;
        if((user = findById(id)) != null){
            userRepository.delete(user);
        }
    }
}
