package com.spquiz.quizappbackend.service;

import com.spquiz.quizappbackend.model.Question;
import com.spquiz.quizappbackend.repo.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

}
