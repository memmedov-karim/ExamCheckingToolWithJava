package com.example.ExamCheckingTool.controller;

import com.example.ExamCheckingTool.dto.NewFieldInfoDto;
import com.example.ExamCheckingTool.entity.FieldInfo;
import com.example.ExamCheckingTool.service.fieldinfo.FieldInfoService;
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
@RequestMapping("/fieldinfo")
public class FieldInfoController {
    private final FieldInfoService fieldInfoService;
    @PostMapping
    public ResponseEntity<FieldInfo> saveFieldInfo(@RequestBody NewFieldInfoDto newFieldInfoDto, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(fieldInfoService.saveFieldInfo(newFieldInfoDto, request));
    }


}
