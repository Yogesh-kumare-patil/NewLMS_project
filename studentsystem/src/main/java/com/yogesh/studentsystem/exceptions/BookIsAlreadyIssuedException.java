package com.yogesh.studentsystem.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookIsAlreadyIssuedException  extends RuntimeException{

    String recourceName;
    String fieldName;
    long fieldValue;

    public BookIsAlreadyIssuedException(String recourceName, String fieldName, long fieldValue) {

        super(String.format("%s is already Issued book%s : %s and you will be in queue", recourceName,fieldName,fieldValue));
        this.recourceName = recourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}