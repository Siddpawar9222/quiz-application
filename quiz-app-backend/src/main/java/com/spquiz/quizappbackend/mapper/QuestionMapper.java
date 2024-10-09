//package com.spquiz.quizappbackend.mapper;
//
//import com.spquiz.quizappbackend.dto.QuestionDto;
//import com.spquiz.quizappbackend.model.Question;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.factory.Mappers;
//
//import java.util.List;
//
//@Mapper
//public interface QuestionMapper {
//    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);
//
//    @Mapping(target = "queId", ignore = true)
//    Question toEntity(QuestionDto questionDto);
//
//    QuestionDto toDto(Question question);
//
//
//
//
//}