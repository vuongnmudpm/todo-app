package com.vuongnm.controller;

import com.vuongnm.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @RequestMapping("auth/denied")
    public ApiResponse<String> authenticationDenied() {
        return new ApiResponse<>(null, "Tai khoan khong dung", false);
    }
}
