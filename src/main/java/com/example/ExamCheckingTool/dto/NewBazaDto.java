package com.example.ExamCheckingTool.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NewBazaDto {
    private List<Long> affectedargumentids;
    @NotNull(message = "howmanyscorethatwrongaffectedtocorrect is required")
    private int howmanyscorethatwrongaffectedtocorrect;
}
