package com.example.ExamCheckingTool.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class FieldInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String fieldname;
    @Column(nullable = false)
    private int starterindex;
    @Column(nullable = false)
    private int finishindex;
    @Column(nullable = false)
    private boolean isaffectthescore=false;
    @ManyToOne
    @JoinColumn(name="answerpaperdesign_id",nullable = false)
    @JsonIgnore
    private AnswerPaperDesign answerpaperdesign;
}
