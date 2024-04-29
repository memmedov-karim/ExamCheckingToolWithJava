package com.example.ExamCheckingTool.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewCorrectAnswerDto {

    @NotBlank(message = "Combinationofarguments is required")
    private String combinationofarguments;
    @NotNull(message = "Baza id is required")
    private Long baza_id;
}
