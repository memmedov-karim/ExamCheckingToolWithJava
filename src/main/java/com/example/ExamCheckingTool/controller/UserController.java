package com.example.ExamCheckingTool.controller;

import com.example.ExamCheckingTool.dto.NewUserDto;
import com.example.ExamCheckingTool.entity.User;
import com.example.ExamCheckingTool.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody NewUserDto newUser){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(newUser));
    }

    @GetMapping
    public ResponseEntity<List<User>> allUsers(){

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.allUsers());
    }
}
