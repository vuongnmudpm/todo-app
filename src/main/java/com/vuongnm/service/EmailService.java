package com.vuongnm.service;

import org.springframework.http.ResponseEntity;

public interface EmailService {
    public ResponseEntity<String> sendEmail(String to, String subject, String text);
}
