package com.example.ExamCheckingTool.service.answerpaperdesign;

import com.example.ExamCheckingTool.dto.NewAnswerPaperDesignDto;
import com.example.ExamCheckingTool.entity.AnswerPaperDesign;
import jakarta.servlet.http.HttpServletRequest;

public interface AnswerPaperDesignService {

    AnswerPaperDesign saveAnswerPaperDesign(NewAnswerPaperDesignDto newAnswerPaperDesignDto, HttpServletRequest request);
}
