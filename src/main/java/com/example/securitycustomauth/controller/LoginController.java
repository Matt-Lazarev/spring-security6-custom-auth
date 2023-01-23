package com.example.securitycustomauth.controller;

import com.example.securitycustomauth.security.dto.UsernamePasswordAuthenticationRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final AuthenticationManager authenticationManager;

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody UsernamePasswordAuthenticationRequest credentials, HttpServletRequest request){
        Authentication authenticationRequest = new
                UsernamePasswordAuthenticationToken(credentials.username(), credentials.password());

        try{
            Authentication authenticationResult = authenticationManager.authenticate(authenticationRequest);
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(authenticationResult);

            HttpSession session = request.getSession(true);
            session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
        }
        catch (Exception exception){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exception.getMessage());
        }

        return ResponseEntity.ok().build();
    }
}
