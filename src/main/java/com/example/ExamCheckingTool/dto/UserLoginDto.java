package com.example.ExamCheckingTool.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserLoginDto {
    @NotBlank(message = "Email is required")
    @Email(message = "Email is not valid format")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
}
