package com.spquiz.quizappbackend.exception;

public class UsernameAlreadyExistException extends Exception {
      public UsernameAlreadyExistException(String message){
          super(message);
      }
}
