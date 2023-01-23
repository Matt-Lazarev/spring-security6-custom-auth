package com.example.securitycustomauth.security.dto;

public record UsernamePasswordAuthenticationRequest
        (String username, String password) {
}
