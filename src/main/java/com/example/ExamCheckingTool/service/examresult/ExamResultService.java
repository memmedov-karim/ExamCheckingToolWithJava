package com.example.ExamCheckingTool.service.examresult;

import com.example.ExamCheckingTool.entity.Baza;
import com.example.ExamCheckingTool.entity.CorrectAnswer;
import com.example.ExamCheckingTool.entity.FieldInfo;
import com.example.ExamCheckingTool.entity.User;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ExamResultService {
    Map<String,Object> getStudentFullInfo(String line, User existingUser, List<CorrectAnswer> correctanswers, int howmanyscorethatwrongaffectedtocorrect, List<FieldInfo> fieldInfoList, List<FieldInfo> userInfos);

    List<Map<String,Object>> startChechkingProcess(HttpServletRequest request,Long baza_id) throws IOException;
}
