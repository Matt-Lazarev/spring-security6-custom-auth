package com.example.securitycustomauth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public String getStartMessage(){
        return "GET Hello!";
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String postStartMessage(){
        return "POST Hello!";
    }

    @GetMapping("/test")
    public String getTestMessage(Authentication authentication){
        return "Test authorized message " + authentication.getPrincipal();
    }
}
