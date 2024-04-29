package com.example.ExamCheckingTool.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Baza {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ElementCollection
    private List<Long> affectedargumentids;
    private String filesecureurl;
    private int howmanyscorethatwrongaffectedtocorrect=0;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    @JsonIgnore
    private User user;
    @OneToMany(mappedBy = "baza",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CorrectAnswer> correctanswers;
}
