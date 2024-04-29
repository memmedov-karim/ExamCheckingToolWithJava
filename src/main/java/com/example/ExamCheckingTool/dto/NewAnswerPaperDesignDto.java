package com.example.ExamCheckingTool.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewAnswerPaperDesignDto {
    @NotBlank(message="Name is required")
    private String name;

}
