package com.spquiz.quizappbackend.mapper;

import com.spquiz.quizappbackend.dto.QuizDto;
import com.spquiz.quizappbackend.model.Quiz;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface QuizMapper {
    QuizMapper INSTANCE = Mappers.getMapper(QuizMapper.class);

    @Mapping(target = "quizId", ignore = true)
    Quiz toEntity(QuizDto quizDto);

    @Mapping(target = "questions", ignore = true)
    QuizDto toDto(Quiz quiz);

    List<QuizDto> toDto(List<Quiz> quizList);

}
