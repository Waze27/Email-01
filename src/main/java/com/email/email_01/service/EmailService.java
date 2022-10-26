package com.email.email_01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendTo(String email, String title, String text){
        SimpleMailMessage sms = new SimpleMailMessage();
        sms.setTo(email);
        sms.setSubject(title);
        sms.setText(text);
        javaMailSender.send(sms);
    }
}
