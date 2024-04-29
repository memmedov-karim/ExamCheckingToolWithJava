package com.example.ExamCheckingTool.service.correctanswer;

import com.example.ExamCheckingTool.dto.NewCorrectAnswerDto;
import com.example.ExamCheckingTool.entity.CorrectAnswer;
import jakarta.servlet.http.HttpServletRequest;

public interface CorrectAnswerService {

    CorrectAnswer saveCorrectAnswer(NewCorrectAnswerDto newCorrectAnswerDto, HttpServletRequest request);
}
