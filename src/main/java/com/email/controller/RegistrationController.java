package com.email.controller;


import com.email.entity.User;
import com.email.service.EmailService;
import com.email.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class RegistrationController {


    private UserService userService;

    private EmailService emailService;
    @Autowired
    public RegistrationController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @PostMapping("/register")
    public Map<String,String> registerUser(@RequestBody User user){
        User user1 = userService.registerUser(user);
       return emailService.sendOtpEmail(user.getEmail());
    }
}
