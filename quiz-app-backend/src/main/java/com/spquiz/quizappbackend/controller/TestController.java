package com.spquiz.quizappbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {
    @GetMapping("/welcome")
    public String testApplication(){
        return "Welcome to Quiz Application" ;
    }
}
