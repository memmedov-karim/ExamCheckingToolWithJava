package com.example.ExamCheckingTool.entity;

import com.example.ExamCheckingTool.dto.AnswerStatsDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class CorrectAnswerForOneSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String subjectname;
    @Column(nullable = false)
    private String correctanswersseriesly;
    @Column(nullable = false)
    private double scoreforonecorrectanswer;
    @ManyToOne
    @JoinColumn(name = "correctanswer_id",nullable = false)
    @JsonIgnore
    private CorrectAnswer correctanswer;
    private String createStatusWithPlusAndMinus(String studentAnswerSeriesly) {
        StringBuilder statusBuilder = new StringBuilder();
        char[] charsStudent = studentAnswerSeriesly.toCharArray();
        char[] charsCorrect = this.correctanswersseriesly.toCharArray();
        for (int i = 0; i < Math.min(charsCorrect.length, charsStudent.length); i++) {
            char userAnswer = charsStudent[i];
            char correctAnswer = charsCorrect[i];
            if (userAnswer == correctAnswer && userAnswer!=' ') {
                statusBuilder.append("+");
            } else if (userAnswer != correctAnswer && userAnswer != ' ') {
                statusBuilder.append("-");
            } else {
                statusBuilder.append(" ");
            }
        }
        return statusBuilder.toString();
    }
    public AnswerStatsDto calculateAnswerStats(String studentAnswerSeriesly,int num) {
        int correctAnswer = 0;
        int wrongAnswer = 0;
        int emptyAnswer = 0;
        StringBuilder statusBuilder = new StringBuilder();
        char[] charsStudent = studentAnswerSeriesly.toCharArray();
        char[] charsCorrect = this.correctanswersseriesly.toCharArray();
        for (int i = 0; i < Math.min(charsCorrect.length, charsStudent.length); i++) {
            char userAnswer = charsStudent[i];
            char correctAnswerChar = charsCorrect[i];
            if (userAnswer == correctAnswerChar && userAnswer != ' ') {
                correctAnswer++;
                statusBuilder.append("+");
            } else if (userAnswer != correctAnswerChar && userAnswer != ' ') {
                wrongAnswer++;
                statusBuilder.append("-");
            } else {
                emptyAnswer++;
                statusBuilder.append(" ");
            }
        }
        double totalScore = this.scoreforonecorrectanswer*correctAnswer-num*((double) wrongAnswer /4);
        AnswerStatsDto ansd = new AnswerStatsDto();
        ansd.setSubjectname(this.subjectname);
        ansd.setCorrectanswersseriesly(this.correctanswersseriesly);
        ansd.setStudentanswerseriesly(studentAnswerSeriesly);
        ansd.setStatuswithplusandminus(statusBuilder.toString());
        ansd.setCorrectAnswer(correctAnswer);
        ansd.setWrongAnswer(wrongAnswer);
        ansd.setEmptyAnswer(emptyAnswer);
        ansd.setScore(totalScore<0 ? 0 : totalScore);
        return ansd;
    }

}
