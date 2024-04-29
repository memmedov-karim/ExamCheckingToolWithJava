package com.example.ExamCheckingTool.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerStatsDto {
        private String subjectname;
        private String correctanswersseriesly;
        private String studentanswerseriesly;
        private String statuswithplusandminus;
        private  int correctAnswer;
        private  int wrongAnswer;
        private  int emptyAnswer;
        private double score;
}
