package com.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    private final UserService userService;
    @Autowired
    public EmailService(JavaMailSender javaMailSender, UserService userService) {
        this.javaMailSender = javaMailSender;
        this.userService = userService;
    }

    public String generateOtp(){
       return String.format("%06d",new java.util.Random().nextInt(1000000));

    }
    public Map<String, String> sendOtpEmail(String email) {
        String otp = generateOtp();
        sendEmail(email,"otp for email verification","your otp is: " +otp);
        Map<String,String> response = new HashMap<>();
        response.put("status","success");
        response.put("message","otp send successfully");
        return response;
    }

    private void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("your.gmail@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
}
