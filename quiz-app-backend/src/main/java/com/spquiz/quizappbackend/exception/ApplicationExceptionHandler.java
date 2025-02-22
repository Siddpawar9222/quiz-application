package com.spquiz.quizappbackend.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException exception){
        Map<String, String> errorMap = new HashMap<>() ;
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
      return  errorMap ;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BadRequestException.class)
    public Map<String, String> handleBadRequestException(BadRequestException exception){
        Map<String, String> errorMap = new HashMap<>() ;
        errorMap.put("errorMg" ,exception.getMessage()) ;
      return  errorMap ;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ResourceUnavailableException.class)
    public Map<String, String> handleResourceUnavailableException(ResourceUnavailableException exception){
        Map<String, String> errorMap = new HashMap<>() ;
        errorMap.put("errorMg" ,exception.getMessage()) ;
        return  errorMap ;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UsernameAlreadyExistException.class)
    public Map<String, String> handleUsernameAlreadyExistException(UsernameAlreadyExistException exception){
        Map<String, String> errorMap = new HashMap<>() ;
        errorMap.put("errorMg" ,exception.getMessage()) ;
        return  errorMap ;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(LoginException.class)
    public Map<String, String> LoginException(LoginException exception){
        Map<String, String> errorMap = new HashMap<>() ;
        errorMap.put("errorMg" ,exception.getMessage()) ;
        return  errorMap ;
    }
}
