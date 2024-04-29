package com.example.ExamCheckingTool.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewCorrectAnswerForOneSubjectDto {
    @NotBlank(message = "Subject name is required")
    private String subjectname;
    @NotBlank(message = "Correct answers is required")
    private String correctanswersseriesly;
    @NotNull(message = "Score for one correct answer is required")
    private double scoreforonecorrectanswer;
    @NotNull(message = "Correct answer id is required")
    private Long correctanswer_id;
}
