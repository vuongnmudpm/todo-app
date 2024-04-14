package com.vuongnm.service.implement;

import com.vuongnm.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImplement implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public ResponseEntity<String> sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        try {
            javaMailSender.send(message);
            return new ResponseEntity<>("Send mail successful!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Send mail fail!" + e, HttpStatus.NOT_FOUND);
        }
    }
}
