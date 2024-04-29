package com.example.ExamCheckingTool.service.examresult;

import com.example.ExamCheckingTool.entity.Baza;
import com.example.ExamCheckingTool.entity.CorrectAnswer;
import com.example.ExamCheckingTool.entity.FieldInfo;
import com.example.ExamCheckingTool.entity.User;
import com.example.ExamCheckingTool.exception.NotFoundException;
import com.example.ExamCheckingTool.repository.BazaRepository;
import com.example.ExamCheckingTool.repository.FieldInfoRepository;
import com.example.ExamCheckingTool.security.JwtService;
import com.example.ExamCheckingTool.service.correctanswerforonesubject.CorrectAnswerForOneSubjectService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@RequiredArgsConstructor
public class ExamResultServiceImpl implements ExamResultService{
    private final CorrectAnswerForOneSubjectService correctAnswerForOneSubjectService;
    private final BazaRepository bazaRepository;
    private final FieldInfoRepository fieldInfoRepository;
    private final JwtService jwtService;
    @Override
    public Map<String,Object> getStudentFullInfo(String line, User existingUser, List<CorrectAnswer> correctanswers, int howmanyscorethatwrongaffectedtocorrect, List<FieldInfo> fieldInfoList, List<FieldInfo> userInfos){
        Map<String,Object> ufd = new HashMap<>();
        int linelength = line.length();
        for(FieldInfo f:userInfos){
            String key = f.getFieldname();
            Object value = line.substring(f.getStarterindex(),Math.min(f.getFinishindex(),linelength));
            ufd.put(key,value);
        }
        ufd.put("answers",correctAnswerForOneSubjectService.findCorrectAnswerForLine(line,correctanswers,howmanyscorethatwrongaffectedtocorrect,fieldInfoList));
        return ufd;
    }

    @Override
    public List<Map<String,Object>> startChechkingProcess(HttpServletRequest request, Long baza_id) throws IOException {
        User u = jwtService.getUserIdFromToken(request,"token");
        Baza existingBaza = bazaRepository.findById(baza_id)
                .orElseThrow(()->new NotFoundException("There is not baza with this id"));
        if(existingBaza.getFilesecureurl()==null){
            throw new NotFoundException("File not found in this baza");
        }
        List<CorrectAnswer> correctAnswers = existingBaza.getCorrectanswers();
        int howmanyscorethatwrongaffectedtocorrect = existingBaza.getHowmanyscorethatwrongaffectedtocorrect();
        List<FieldInfo> userInfos = u.getAnswerpaperdesign().getFieldinfos();
        List<FieldInfo> fieldInfoList = fieldInfoRepository.findAllByIdIn(existingBaza.getAffectedargumentids());
        List<Map<String,Object>> udata = new ArrayList<>();
        URL url = new URL(existingBaza.getFilesecureurl());
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                udata.add(this.getStudentFullInfo(line,u,correctAnswers,howmanyscorethatwrongaffectedtocorrect,fieldInfoList,userInfos));
            }
        }
        return udata;
    }
}
