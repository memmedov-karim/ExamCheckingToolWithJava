package com.example.ExamCheckingTool.service.correctanswerforonesubject;

import com.example.ExamCheckingTool.dto.AnswerStatsDto;
import com.example.ExamCheckingTool.dto.NewCorrectAnswerForLineDto;
import com.example.ExamCheckingTool.dto.NewCorrectAnswerForOneSubjectDto;
import com.example.ExamCheckingTool.entity.*;
import com.example.ExamCheckingTool.exception.NotFoundException;
import com.example.ExamCheckingTool.repository.BazaRepository;
import com.example.ExamCheckingTool.repository.CorrectAnswerForOneSubjectRepository;
import com.example.ExamCheckingTool.repository.CorrectAnswerRepository;
import com.example.ExamCheckingTool.repository.FieldInfoRepository;
import com.example.ExamCheckingTool.security.JwtService;
import com.example.ExamCheckingTool.validator.DtoValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CorrectAnswerForOneSubjectServiceImpl implements CorrectAnswerForOneSubjectService{
    private final CorrectAnswerForOneSubjectRepository correctAnswerForOneSubjectRepository;
    private final DtoValidator dtoValidator;
    private final JwtService jwtService;
    private final CorrectAnswerRepository correctAnswerRepository;
    private final BazaRepository bazaRepository;
    private final FieldInfoRepository fieldInfoRepository;
    @Override
    public CorrectAnswerForOneSubject saveCorrectAnswerForOneSubject(@Valid @NotNull NewCorrectAnswerForOneSubjectDto newCorrectAnswerForOneSubjectDto, HttpServletRequest request){
        User existingUser = jwtService.getUserIdFromToken(request,"token");
        dtoValidator.validateDto(newCorrectAnswerForOneSubjectDto);
        CorrectAnswer existingCorrectAnswer = correctAnswerRepository.findById(newCorrectAnswerForOneSubjectDto.getCorrectanswer_id())
                .orElseThrow(()->new NotFoundException("There is not correctanswer with this id"));
        CorrectAnswerForOneSubject newCorrectAnswerForOneSubjectInstance = new CorrectAnswerForOneSubject();

        newCorrectAnswerForOneSubjectInstance.setSubjectname(newCorrectAnswerForOneSubjectDto.getSubjectname());
        newCorrectAnswerForOneSubjectInstance.setCorrectanswersseriesly(newCorrectAnswerForOneSubjectDto.getCorrectanswersseriesly());
        newCorrectAnswerForOneSubjectInstance.setScoreforonecorrectanswer(newCorrectAnswerForOneSubjectDto.getScoreforonecorrectanswer());
        newCorrectAnswerForOneSubjectInstance.setCorrectanswer(existingCorrectAnswer);

        return correctAnswerForOneSubjectRepository.save(newCorrectAnswerForOneSubjectInstance);
    }


    @Override
    public ArrayList<AnswerStatsDto> findCorrectAnswerForLine(String line,List<CorrectAnswer> correctanswers,int howmanyscorethatwrongaffectedtocorrect,List<FieldInfo> fieldInfoList){
        StringBuilder combination = new StringBuilder();
        for(FieldInfo f:fieldInfoList){
            int start = f.getStarterindex();
            int end = f.getFinishindex();
            combination.append(line,start, end);
        }
        CorrectAnswer c = correctanswers.stream()
                .filter(t -> Objects.equals(t.getCombinationofarguments(), combination.toString()))
                .findFirst().orElse(null);
        if(c!=null) {
            List<CorrectAnswerForOneSubject> cafs = c.getCorrectanswersforsubjects();
            ArrayList<AnswerStatsDto> a = new ArrayList<AnswerStatsDto>();
            int startindex = 66;
            for (CorrectAnswerForOneSubject caf : cafs) {
                int lastindex = startindex + caf.getCorrectanswersseriesly().length();
                System.out.println("Process in findCorrectAnswerForLine method in CorrectAnswerForOneSubjectService class");
                String eachLine = line.substring(startindex, Math.min(lastindex, line.length()));
                AnswerStatsDto an = caf.calculateAnswerStats(eachLine, howmanyscorethatwrongaffectedtocorrect);
                a.add(an);
                startindex = lastindex;
            }
            return a;
        }
        else{
            return null;
        }
    }
}
