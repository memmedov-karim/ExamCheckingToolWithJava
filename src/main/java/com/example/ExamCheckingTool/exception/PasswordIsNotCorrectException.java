package com.example.ExamCheckingTool.exception;

public class PasswordIsNotCorrectException extends RuntimeException{

    public PasswordIsNotCorrectException(String msg){
        super(msg);
    }
}
