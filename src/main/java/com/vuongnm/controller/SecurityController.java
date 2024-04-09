package com.vuongnm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class SecurityController {
    @GetMapping("/security/index")
    public String index(Principal principal) {
        return "Hello world " + principal.getName() + " " ;
    }
}
