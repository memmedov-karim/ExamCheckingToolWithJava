package com.example.ExamCheckingTool.controller;

import com.example.ExamCheckingTool.dto.UserLoginDto;
import com.example.ExamCheckingTool.service.auth.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDto userLoginDto, HttpServletResponse response){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(authService.login(userLoginDto, response));
    }
}
