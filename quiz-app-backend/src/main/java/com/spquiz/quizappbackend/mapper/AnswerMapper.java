package com.spquiz.quizappbackend.mapper;

import com.spquiz.quizappbackend.dto.AnswerDto;
import com.spquiz.quizappbackend.model.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnswerMapper {
    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    @Mapping(target = "ansId", ignore = true)
    Answer toEntity(AnswerDto answerDTO);

    @Mapping(target = "isCorrect",ignore = true)
    AnswerDto toDto(Answer answer);

}
