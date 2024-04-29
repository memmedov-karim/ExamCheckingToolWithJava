package com.example.ExamCheckingTool.service.user;

import com.example.ExamCheckingTool.dto.NewUserDto;
import com.example.ExamCheckingTool.entity.User;

import java.util.List;

public interface UserService {

    String saveUser(NewUserDto newUser);
    List<User> allUsers();
}
