package com.example.ExamCheckingTool.service.file;

import com.example.ExamCheckingTool.dto.NewCorrectAnswerForLineDto;
import com.example.ExamCheckingTool.entity.Baza;
import com.example.ExamCheckingTool.entity.CorrectAnswer;
import com.example.ExamCheckingTool.entity.FieldInfo;
import com.example.ExamCheckingTool.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;

public interface FileUploadService {

    String uploadFile(MultipartFile file) throws IOException;

    String saveFileInBaza(MultipartFile file, HttpServletRequest request,Long baza_id) throws IOException;
}
