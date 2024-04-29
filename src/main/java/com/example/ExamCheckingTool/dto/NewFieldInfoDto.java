package com.example.ExamCheckingTool.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewFieldInfoDto {

    @NotBlank(message="Fieldname is required")
    private String fieldname;
    @NotNull(message = "Starterindex is required")
    private int startterindex;
    @NotNull(message = "Finishindex is required")
    private int finishindex;
    private boolean isaffectthescore;
    @NotNull(message = "Answerpaperdesignid is required")
    private Long answerpaperdesignid;
}
