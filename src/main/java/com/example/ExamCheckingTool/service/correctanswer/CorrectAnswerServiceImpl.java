package com.example.ExamCheckingTool.service.correctanswer;

import com.example.ExamCheckingTool.dto.NewCorrectAnswerDto;
import com.example.ExamCheckingTool.entity.Baza;
import com.example.ExamCheckingTool.entity.CorrectAnswer;
import com.example.ExamCheckingTool.entity.User;
import com.example.ExamCheckingTool.exception.NotFoundException;
import com.example.ExamCheckingTool.repository.BazaRepository;
import com.example.ExamCheckingTool.repository.CorrectAnswerRepository;
import com.example.ExamCheckingTool.security.JwtService;
import com.example.ExamCheckingTool.validator.DtoValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CorrectAnswerServiceImpl implements CorrectAnswerService{
    private final CorrectAnswerRepository correctAnswerRepository;
    private final DtoValidator dtoValidator;
    private final JwtService jwtService;
    private final BazaRepository bazaRepository;
    @Override

    public CorrectAnswer saveCorrectAnswer(@Valid @NotNull NewCorrectAnswerDto newCorrectAnswerDto, HttpServletRequest request){
        User existingUser = jwtService.getUserIdFromToken(request,"token");
        dtoValidator.validateDto(newCorrectAnswerDto);
        Baza existingBaza = bazaRepository.findById(newCorrectAnswerDto.getBaza_id())
                .orElseThrow(()->new NotFoundException("There is not baza with this id"));
        //checking
        CorrectAnswer newCorrectAnswerInstance = new CorrectAnswer();
        newCorrectAnswerInstance.setCombinationofarguments(newCorrectAnswerDto.getCombinationofarguments());
        newCorrectAnswerInstance.setBaza(existingBaza);

        return correctAnswerRepository.save(newCorrectAnswerInstance);
    }
}
