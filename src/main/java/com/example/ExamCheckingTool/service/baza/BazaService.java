package com.example.ExamCheckingTool.service.baza;

import com.example.ExamCheckingTool.dto.NewBazaDto;
import com.example.ExamCheckingTool.entity.Baza;
import jakarta.servlet.http.HttpServletRequest;

public interface BazaService {

    Baza saveBaza(NewBazaDto newBazaDto, HttpServletRequest request);

}
