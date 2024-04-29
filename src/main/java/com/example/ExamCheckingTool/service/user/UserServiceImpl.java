package com.example.ExamCheckingTool.service.user;

import com.example.ExamCheckingTool.dto.NewUserDto;
import com.example.ExamCheckingTool.entity.User;
import com.example.ExamCheckingTool.exception.AlreadyExistException;
import com.example.ExamCheckingTool.repository.UserRepository;
import com.example.ExamCheckingTool.validator.DtoValidator;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    //Repositories
    private final UserRepository userRepository;

    //Others
    private final DtoValidator dtoValidator;
    @Override
    public String saveUser(@Valid @NotNull NewUserDto newUser){
        dtoValidator.validateDto(newUser);
        String email = newUser.getEmail();
        User existingUser = userRepository.findByEmail(email);
        if(existingUser!=null){
            throw new AlreadyExistException("User already exist with "+email);
        }
        User newUserInstance = new User();
        newUserInstance.setEmail(email);
        newUserInstance.setPassword(newUser.getPassword());
        userRepository.save(newUserInstance);
        return "registered";
    }

    @Override
    public List<User> allUsers(){
        return userRepository.findAll();
    }
}

