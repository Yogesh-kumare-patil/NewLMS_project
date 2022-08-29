package com.yogesh.studentsystem.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InvalidFieldException extends RuntimeException{
    String message;

    public InvalidFieldException(String message){
        this.message=message;
    }
}
