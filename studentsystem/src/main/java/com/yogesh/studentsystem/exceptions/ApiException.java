package com.yogesh.studentsystem.exceptions;

public class ApiException extends RuntimeException{
    public ApiException(String message) {
        super(message);

    }

    public ApiException() {
        super();

    }
}
