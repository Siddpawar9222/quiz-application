package com.spquiz.quizappbackend.dto;

import com.spquiz.quizappbackend.model.Answer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionDto {
    private Long queId;
    private String text;
    private List<AnswerDto> answers;
}
