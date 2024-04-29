package com.example.ExamCheckingTool.service.file;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import com.example.ExamCheckingTool.dto.NewCorrectAnswerForLineDto;
import com.example.ExamCheckingTool.entity.Baza;
import com.example.ExamCheckingTool.entity.CorrectAnswer;
import com.example.ExamCheckingTool.entity.FieldInfo;
import com.example.ExamCheckingTool.entity.User;
import com.example.ExamCheckingTool.exception.NotFoundException;
import com.example.ExamCheckingTool.repository.BazaRepository;
import com.example.ExamCheckingTool.repository.FieldInfoRepository;
import com.example.ExamCheckingTool.security.JwtService;
import com.example.ExamCheckingTool.service.correctanswer.CorrectAnswerService;
import com.example.ExamCheckingTool.service.correctanswerforonesubject.CorrectAnswerForOneSubjectService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FileUploadServiceImpl implements FileUploadService{
    private String cloudName="dvaqydzob";
    private String apiKey="827576999974998";
    private String apiSecret="g07jmjsNZP-k-xNWtA5MVrhlNsQ";
    private final Cloudinary cloudinary;
    private final JwtService jwtService;
    private final BazaRepository bazaRepository;
    public FileUploadServiceImpl(JwtService jwtService, CorrectAnswerService correctAnswerService, FieldInfoRepository fieldInfoRepository, CorrectAnswerForOneSubjectService correctAnswerForOneSubjectService, BazaRepository bazaRepository) {
        this.jwtService = jwtService;
        this.bazaRepository = bazaRepository;
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "Sexsi cloudinaryname",
                "api_key", "cloudinaryapikey",
                "api_secret", "cloudinarysecretkey"));
    }
    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        String uniqueFilename = file.getOriginalFilename() + "_" + System.currentTimeMillis();
        return (String) cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap(
                "public_id", uniqueFilename,
                "resource_type", "auto"
        )).get("secure_url");
    }

    @Override
    public String saveFileInBaza(MultipartFile file, HttpServletRequest request,Long baza_id) throws IOException {
        User existingUser = jwtService.getUserIdFromToken(request,"token");
        Baza existingBaza = bazaRepository.findById(baza_id)
                .orElseThrow(()->new NotFoundException("There is not baza with this id"));
        String secureurl = this.uploadFile(file);
        existingBaza.setFilesecureurl(secureurl);
        bazaRepository.save(existingBaza);
        return secureurl;
    }

}
