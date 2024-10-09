package com.spquiz.quizappbackend.service;


import com.spquiz.quizappbackend.dto.QuizDto;
import com.spquiz.quizappbackend.mapper.QuizMapper;
import com.spquiz.quizappbackend.model.Answer;
import com.spquiz.quizappbackend.model.Question;
import com.spquiz.quizappbackend.model.Quiz;
import com.spquiz.quizappbackend.repo.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class QuizService {


    private final QuizRepository quizRepository;

    @Transactional
    public String saveQuiz(QuizDto quizDto) {
        Quiz quiz = QuizMapper.dtoToEntity(quizDto);
        Quiz saveQuiz = quizRepository.save(quiz);
        return "Quiz saved successfully with id " + saveQuiz.getQuizId() ;
    }

    @Transactional
    public List<QuizDto> getAvailableQuiz() {
        List<Quiz> allQuiz = quizRepository.findAll();
        List<QuizDto> quizDtoList = new ArrayList<>();
        for(Quiz quiz : allQuiz){
            QuizDto quizDto = QuizMapper.entityToDtoSkipQuestions(quiz);
            quizDtoList.add(quizDto);
        }
        return quizDtoList;
    }


    // Used custom Mapper
//    @Transactional
//    public List<QuestionDto> getQuizById(Long id) {
//        Optional<Quiz> optionalQuiz = quizRepository.findById(id);
//        if (!optionalQuiz.isPresent()) {
//            throw new RuntimeException("Data Not Found");
//        }
//        List<QuestionDto> questionDtos = new ArrayList<>();
//        for (Question question : optionalQuiz.get().getQuestions()) {
//            List<AnswerDto> answerDto = new ArrayList<>();
//            for (Answer answer : question.getAnswers()) {
//                AnswerDto answerDto1 = AnswerDto.builder()
//                        .ansId(answer.getAnsId())
//                        .text(answer.getText())
//                        .isCorrect(false).build();
//                answerDto.add(answerDto1);
//            }
//            QuestionDto questionDto = QuestionDto.builder()
//                    .queId(question.getQueId())
//                    .text(question.getText())
//                    .answers(answerDto)
//                    .build();
//
//            questionDtos.add(questionDto);
//        }
//        return questionDtos;
//    }

}
