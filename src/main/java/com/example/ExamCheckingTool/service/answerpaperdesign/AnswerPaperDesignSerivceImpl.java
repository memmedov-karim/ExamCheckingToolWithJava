package com.example.ExamCheckingTool.service.answerpaperdesign;

import com.example.ExamCheckingTool.dto.NewAnswerPaperDesignDto;
import com.example.ExamCheckingTool.entity.AnswerPaperDesign;
import com.example.ExamCheckingTool.entity.User;
import com.example.ExamCheckingTool.repository.AnswerPaperDesignRepository;
import com.example.ExamCheckingTool.security.JwtService;
import com.example.ExamCheckingTool.validator.DtoValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerPaperDesignSerivceImpl implements AnswerPaperDesignService {
    private final JwtService jwtService;
    private final DtoValidator dtoValidator;
    private final AnswerPaperDesignRepository answerPaperDesignRepository;
    @Override
    public AnswerPaperDesign saveAnswerPaperDesign(@Valid @NotNull NewAnswerPaperDesignDto newAnswerPaperDesignDto, HttpServletRequest request){
        User existingUser = jwtService.getUserIdFromToken(request,"token");
        dtoValidator.validateDto(newAnswerPaperDesignDto);

        AnswerPaperDesign newAnswerpaperDesignInstance = new AnswerPaperDesign();
        newAnswerpaperDesignInstance.setName(newAnswerPaperDesignDto.getName());
        newAnswerpaperDesignInstance.setUser(existingUser);

        return answerPaperDesignRepository.save(newAnswerpaperDesignInstance);

    }

}
