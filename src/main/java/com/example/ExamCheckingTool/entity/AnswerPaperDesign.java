package com.example.ExamCheckingTool.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class AnswerPaperDesign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    @JsonIgnore
    private User user;
    @OneToMany(mappedBy = "answerpaperdesign",cascade = CascadeType.ALL)
    private List<FieldInfo> fieldinfos;
}
