package com.example.ExamCheckingTool.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponseDto {
    private String message;
    private int status;
    private LocalDateTime timestamp;
    public String getTimestamp() {
        return timestamp.toString();
    }
}
