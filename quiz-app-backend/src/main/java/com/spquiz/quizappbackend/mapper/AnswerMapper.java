//package com.spquiz.quizappbackend.mapper;
//
//import com.spquiz.quizappbackend.dto.AnswerDto;
//import com.spquiz.quizappbackend.model.Answer;
//
//
//@Mapper
//public interface AnswerMapper {
//    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);
//
//    @Mapping(target = "ansId", ignore = true)
//    Answer toEntity(AnswerDto answerDTO);
//
//    @Mapping(target = "isCorrect",ignore = true)
//    AnswerDto toDto(Answer answer);
//
//}
