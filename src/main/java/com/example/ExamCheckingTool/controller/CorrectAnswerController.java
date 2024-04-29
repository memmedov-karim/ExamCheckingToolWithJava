package com.example.ExamCheckingTool.controller;

import com.example.ExamCheckingTool.dto.NewCorrectAnswerDto;
import com.example.ExamCheckingTool.entity.CorrectAnswer;
import com.example.ExamCheckingTool.service.correctanswer.CorrectAnswerService;
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
@RequestMapping("/correctanswer")
public class CorrectAnswerController {


    private final CorrectAnswerService correctAnswerService;

    @PostMapping
    public ResponseEntity<CorrectAnswer> saveCorrectAnswer(@RequestBody NewCorrectAnswerDto newCorrectAnswerDto, HttpServletRequest request){

        return ResponseEntity.status(HttpStatus.CREATED).body(correctAnswerService.saveCorrectAnswer(newCorrectAnswerDto, request));
    }
}
