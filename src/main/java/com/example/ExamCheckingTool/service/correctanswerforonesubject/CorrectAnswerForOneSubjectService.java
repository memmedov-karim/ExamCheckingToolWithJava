package com.example.ExamCheckingTool.service.correctanswerforonesubject;

import com.example.ExamCheckingTool.dto.AnswerStatsDto;
import com.example.ExamCheckingTool.dto.NewCorrectAnswerForLineDto;
import com.example.ExamCheckingTool.dto.NewCorrectAnswerForOneSubjectDto;
import com.example.ExamCheckingTool.entity.Baza;
import com.example.ExamCheckingTool.entity.CorrectAnswer;
import com.example.ExamCheckingTool.entity.CorrectAnswerForOneSubject;
import com.example.ExamCheckingTool.entity.FieldInfo;
import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

public interface CorrectAnswerForOneSubjectService {

    CorrectAnswerForOneSubject saveCorrectAnswerForOneSubject(NewCorrectAnswerForOneSubjectDto newCorrectAnswerForOneSubjectDto, HttpServletRequest request);

    ArrayList<AnswerStatsDto> findCorrectAnswerForLine(String line, List<CorrectAnswer> correctanswers,int howmanyscorethatwrongaffectedtocorrect, List<FieldInfo> fieldInfoList);
}
