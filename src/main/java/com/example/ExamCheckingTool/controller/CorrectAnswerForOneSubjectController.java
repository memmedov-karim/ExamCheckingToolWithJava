package com.example.ExamCheckingTool.controller;

import com.example.ExamCheckingTool.dto.AnswerStatsDto;
import com.example.ExamCheckingTool.dto.NewCorrectAnswerForLineDto;
import com.example.ExamCheckingTool.dto.NewCorrectAnswerForOneSubjectDto;
import com.example.ExamCheckingTool.entity.CorrectAnswer;
import com.example.ExamCheckingTool.entity.CorrectAnswerForOneSubject;
import com.example.ExamCheckingTool.service.correctanswerforonesubject.CorrectAnswerForOneSubjectService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/correctanswerforonesubject")
public class CorrectAnswerForOneSubjectController {
    private final CorrectAnswerForOneSubjectService correctAnswerForOneSubjectService;
    @PostMapping
    public ResponseEntity<CorrectAnswerForOneSubject> saveCorrectAnswerForOneSubject(@RequestBody NewCorrectAnswerForOneSubjectDto newCorrectAnswerForOneSubjectDto, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(correctAnswerForOneSubjectService.saveCorrectAnswerForOneSubject(newCorrectAnswerForOneSubjectDto, request));
    }

//    @PostMapping("/find")
//    public ResponseEntity<ArrayList<AnswerStatsDto>>  findCorrectAnswerForLine(@RequestBody NewCorrectAnswerForLineDto newCorrectAnswerForLineDto){
//        return ResponseEntity.status(HttpStatus.CREATED).body(correctAnswerForOneSubjectService.findCorrectAnswerForLine(newCorrectAnswerForLineDto));
//    }

}
