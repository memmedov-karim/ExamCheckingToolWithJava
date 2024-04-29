package com.example.ExamCheckingTool.service.fieldinfo;

import com.example.ExamCheckingTool.dto.NewFieldInfoDto;
import com.example.ExamCheckingTool.entity.FieldInfo;
import jakarta.servlet.http.HttpServletRequest;

public interface FieldInfoService {

    FieldInfo saveFieldInfo(NewFieldInfoDto newFieldInfoDto, HttpServletRequest request);
}
