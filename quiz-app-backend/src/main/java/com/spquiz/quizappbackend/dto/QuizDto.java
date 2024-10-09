package com.spquiz.quizappbackend.dto;

import com.spquiz.quizappbackend.model.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuizDto {
    private Long quizId;
    private String title;
    private  Boolean isActive ;
    private List<QuestionDto> questions;
}
