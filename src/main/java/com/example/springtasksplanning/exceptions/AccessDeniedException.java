package com.example.springtasksplanning.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException() {
        super("Access denied: u have no rights to do this");
    }
    public AccessDeniedException(Throwable cause) {
        super("Access denied: u have no rights to do this", cause);
    }
}
