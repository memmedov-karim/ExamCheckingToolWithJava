package com.example.ExamCheckingTool.service.fieldinfo;

import com.example.ExamCheckingTool.dto.NewFieldInfoDto;
import com.example.ExamCheckingTool.entity.AnswerPaperDesign;
import com.example.ExamCheckingTool.entity.FieldInfo;
import com.example.ExamCheckingTool.entity.User;
import com.example.ExamCheckingTool.exception.NotFoundException;
import com.example.ExamCheckingTool.repository.AnswerPaperDesignRepository;
import com.example.ExamCheckingTool.repository.FieldInfoRepository;
import com.example.ExamCheckingTool.security.JwtService;
import com.example.ExamCheckingTool.validator.DtoValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FieldInfoServiceImpl implements FieldInfoService{
    private final FieldInfoRepository fieldInfoRepository;
    private final AnswerPaperDesignRepository answerPaperDesignRepository;
    private final DtoValidator dtoValidator;
    private final JwtService jwtService;

    @Override
    public FieldInfo saveFieldInfo(@Valid @NotNull NewFieldInfoDto newFieldInfoDto, HttpServletRequest request){
        dtoValidator.validateDto(newFieldInfoDto);
        User existingUser = jwtService.getUserIdFromToken(request,"token");
        AnswerPaperDesign existingAnswerPaperDesign = answerPaperDesignRepository.findById(newFieldInfoDto.getAnswerpaperdesignid())
                .orElseThrow(()->new NotFoundException("There is not AnswerPaperDesign with this id"));
        FieldInfo newFieldInfoInstance = new FieldInfo();
        newFieldInfoInstance.setFieldname(newFieldInfoDto.getFieldname());
        newFieldInfoInstance.setStarterindex(newFieldInfoDto.getStartterindex());
        newFieldInfoInstance.setFinishindex(newFieldInfoDto.getFinishindex());
        newFieldInfoInstance.setAnswerpaperdesign(existingAnswerPaperDesign);
        newFieldInfoInstance.setIsaffectthescore(newFieldInfoDto.isIsaffectthescore());
        return fieldInfoRepository.save(newFieldInfoInstance);
    }

}
