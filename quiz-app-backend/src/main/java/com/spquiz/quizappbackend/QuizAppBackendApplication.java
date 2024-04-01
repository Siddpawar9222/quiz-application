package com.spquiz.quizappbackend;

import com.spquiz.quizappbackend.model.Answer;
import com.spquiz.quizappbackend.model.Question;
import com.spquiz.quizappbackend.model.User;
import com.spquiz.quizappbackend.repo.AnswerRepository;
import com.spquiz.quizappbackend.repo.QuestionRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class QuizAppBackendApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(QuizAppBackendApplication.class, args);


//		QuestionService questionService = context.getBean(QuestionService.class);

// Create the Question entity and associate it with the Answer entity
//		Question question = new Question();
//		question.setText("What is Java?");
//		question.setAnswer(new Answer(null, "Programming Lang"));
//		questionRepository.save(question);

//		Question ques = questionService.getAnswer(3L);
//		System.out.println(ques.getText());


	}

}
