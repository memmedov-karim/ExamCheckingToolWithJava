package com.example.ExamCheckingTool.controller;

import com.example.ExamCheckingTool.dto.NewAnswerPaperDesignDto;
import com.example.ExamCheckingTool.entity.AnswerPaperDesign;
import com.example.ExamCheckingTool.service.answerpaperdesign.AnswerPaperDesignService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/answerpaperdesign")
public class AnswerPaperDesignController {
    private final AnswerPaperDesignService answerPaperDesignService;
    @PostMapping
    public ResponseEntity<AnswerPaperDesign> saveAnswerPaperDesign(@RequestBody NewAnswerPaperDesignDto newAnswerPaperDesignDto, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(answerPaperDesignService.saveAnswerPaperDesign(newAnswerPaperDesignDto, request));
    }
}
