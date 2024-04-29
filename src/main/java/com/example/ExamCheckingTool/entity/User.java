package com.example.ExamCheckingTool.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private AnswerPaperDesign answerpaperdesign;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Baza> bazas;
}
