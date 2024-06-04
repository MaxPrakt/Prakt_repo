package com.example.springtasksplanning.exceptions;

public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException() {
        super("Access denied: u have no rights to do this");
    }
}
