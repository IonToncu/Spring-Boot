package com.example.springbootproject.repo;

import com.example.springbootproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
       List<User> findAll();
       User getUserById(Long id);
       User getUserByUserName(String userName);
}
