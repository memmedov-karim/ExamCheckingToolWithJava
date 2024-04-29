package com.example.ExamCheckingTool.controller;

import com.example.ExamCheckingTool.service.examresult.ExamResultService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/result")
public class ExamResultController {

    private final ExamResultService examResultService;


    @GetMapping("/startchecking/{baza_id}")
    public ResponseEntity<List<Map<String,Object>>> startCheckingProcess(HttpServletRequest request, @PathVariable("baza_id") Long baza_id) throws IOException {

        return ResponseEntity.status(HttpStatus.CREATED).body(examResultService.startChechkingProcess(request,baza_id));
    }
}
