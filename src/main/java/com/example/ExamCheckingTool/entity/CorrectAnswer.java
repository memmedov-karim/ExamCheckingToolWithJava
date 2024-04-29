package com.example.ExamCheckingTool.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class CorrectAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String combinationofarguments;
    @ManyToOne
    @JoinColumn(name = "baza_id",nullable = false)
    @JsonIgnore
    private Baza baza;
    @OneToMany(mappedBy = "correctanswer",cascade = CascadeType.ALL)
    private List<CorrectAnswerForOneSubject> correctanswersforsubjects;
}
