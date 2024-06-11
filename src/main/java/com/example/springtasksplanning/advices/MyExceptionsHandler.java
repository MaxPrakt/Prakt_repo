package com.example.springtasksplanning.advices;

import com.example.springtasksplanning.exceptions.AccessDeniedException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionsHandler {

    @ExceptionHandler
    public String accessDeniedExceptionHandler(AccessDeniedException ex){
        return ex.getMessage();
    }

    @ExceptionHandler
    public String exceptionHandler(EntityNotFoundException ex){
        return ex.getMessage();
    }
}
