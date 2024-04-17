package com.email.service;


import com.email.entity.User;
import com.email.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
     @Autowired
     private UserRepository userRepository;


     public User registerUser(User user) {
          return userRepository.save(user);
     }
}
