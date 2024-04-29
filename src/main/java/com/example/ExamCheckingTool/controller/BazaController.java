package com.example.ExamCheckingTool.controller;

import com.example.ExamCheckingTool.dto.NewBazaDto;
import com.example.ExamCheckingTool.entity.Baza;
import com.example.ExamCheckingTool.service.baza.BazaService;
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
@RequestMapping("/baza")
public class BazaController {

    private final BazaService bazaService;

    @PostMapping
    public ResponseEntity<Baza> saveBaza(@RequestBody NewBazaDto newBazaDto, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(bazaService.saveBaza(newBazaDto, request));
    }
}
