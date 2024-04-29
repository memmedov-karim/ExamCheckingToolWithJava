package com.example.ExamCheckingTool.controller;

import com.example.ExamCheckingTool.dto.NewCorrectAnswerForLineDto;
import com.example.ExamCheckingTool.service.file.FileUploadService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileUploadController {

    private final FileUploadService fileUploadService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFIle(@RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(fileUploadService.uploadFile(file));
    }

    @PostMapping("/saveinbaza")
    public ResponseEntity<String> saveFileInBaza(@RequestParam("file") MultipartFile file, HttpServletRequest request, @RequestParam("baza_id") Long baza_id) throws IOException {

        return ResponseEntity.status(HttpStatus.CREATED).body(fileUploadService.saveFileInBaza(file, request, baza_id));
    }

}
