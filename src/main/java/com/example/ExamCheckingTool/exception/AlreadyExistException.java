package com.example.ExamCheckingTool.exception;

public class AlreadyExistException extends RuntimeException{

    public AlreadyExistException(String msg){
        super(msg);
    }
}
