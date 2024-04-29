package com.example.ExamCheckingTool.service.auth;

import com.example.ExamCheckingTool.dto.UserLoginDto;
import com.example.ExamCheckingTool.entity.User;
import com.example.ExamCheckingTool.exception.NotFoundException;
import com.example.ExamCheckingTool.exception.PasswordIsNotCorrectException;
import com.example.ExamCheckingTool.repository.UserRepository;
import com.example.ExamCheckingTool.security.JwtService;
import com.example.ExamCheckingTool.validator.DtoValidator;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final JwtService jwtService;
    private final DtoValidator dtoValidator;
    private final UserRepository userRepository;
    @Override
    public String login(@Valid @NotNull UserLoginDto userLoginDto, HttpServletResponse response){
        dtoValidator.validateDto(userLoginDto);
        String email = userLoginDto.getEmail();
        String password = userLoginDto.getPassword();
        User existingUser = userRepository.findByEmail(email);
        if(existingUser == null){
            throw new NotFoundException("User not found with this "+email);
        }
        if(!existingUser.getPassword().equals(password)){
            throw new PasswordIsNotCorrectException("Invalid password");
        }
        jwtService.sendTokenWithCookie(existingUser.getId(), "token",response);
        return "Logged in succefully!";
    }
}
