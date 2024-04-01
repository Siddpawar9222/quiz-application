package com.spquiz.quizappbackend.controller;

import com.spquiz.quizappbackend.dto.UserDto;
import com.spquiz.quizappbackend.exception.BadRequestException;
import com.spquiz.quizappbackend.exception.LoginException;
import com.spquiz.quizappbackend.exception.ResourceUnavailableException;
import com.spquiz.quizappbackend.exception.UsernameAlreadyExistException;
import com.spquiz.quizappbackend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final  AuthService authService ;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) throws BadRequestException, ResourceUnavailableException, UsernameAlreadyExistException {
        return ResponseEntity.ok(authService.registerUser(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody UserDto userDto) throws LoginException {
           return  ResponseEntity.ok(authService.authenticateAndGetToken(userDto));
    }

}
