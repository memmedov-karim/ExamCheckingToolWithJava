package com.example.ExamCheckingTool.exception;

public class CookiesNotFoundInRequestException extends RuntimeException{

    public CookiesNotFoundInRequestException(String msg){
        super(msg);
    }
}
