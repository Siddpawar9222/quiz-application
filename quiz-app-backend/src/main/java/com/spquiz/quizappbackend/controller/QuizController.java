package com.spquiz.quizappbackend.controller;

import com.spquiz.quizappbackend.dto.QuestionDto;
import com.spquiz.quizappbackend.dto.QuizDto;
import com.spquiz.quizappbackend.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    private final QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
         return new ResponseEntity<>(quizService.saveQuiz(quizDto), HttpStatus.CREATED);
    }

    @GetMapping ("/get")
    public ResponseEntity<List<QuizDto>> getAvailableQuiz(){
         return  ResponseEntity.ok(quizService.getAvailableQuiz());
    }
//
//    @GetMapping("/get/{id}")
//    public ResponseEntity<List<QuestionDto>> getQuiz(@PathVariable Long id){
//       return ResponseEntity.ok(quizService.getQuizById(id));
//    }
}
