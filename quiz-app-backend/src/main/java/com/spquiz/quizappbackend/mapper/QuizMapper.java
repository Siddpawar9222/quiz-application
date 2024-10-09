package com.spquiz.quizappbackend.mapper;

import com.spquiz.quizappbackend.dto.QuizDto;
import com.spquiz.quizappbackend.model.Quiz;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

public  class QuizMapper {
     public static Quiz dtoToEntity(QuizDto quizDto){
         ModelMapper  modelMapper = new ModelMapper();
         modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
         Quiz quiz = modelMapper.map(quizDto, Quiz.class);
         return quiz ;
     }

    public static QuizDto entityToDto(Quiz quiz){
        ModelMapper  modelMapper = new ModelMapper();
        QuizDto quizDto = modelMapper.map(quiz, QuizDto.class);
        return quizDto ;
    }

    public static QuizDto entityToDtoSkipQuestions(Quiz quiz){
        ModelMapper  modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        PropertyMap<Quiz, QuizDto> map = new PropertyMap<>() {
            @Override
            protected void configure() {
                skip(destination.getQuestions());
            }
        };

        modelMapper.addMappings(map);

        QuizDto quizDto = modelMapper.map(quiz, QuizDto.class);
        return quizDto ;
    }

}
