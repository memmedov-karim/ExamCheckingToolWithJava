package com.example.ExamCheckingTool.service.auth;

import com.example.ExamCheckingTool.dto.UserLoginDto;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {

    String login(UserLoginDto userLoginDto, HttpServletResponse response);
}
