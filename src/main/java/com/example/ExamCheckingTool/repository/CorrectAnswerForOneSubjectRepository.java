package com.example.ExamCheckingTool.repository;

import com.example.ExamCheckingTool.entity.CorrectAnswerForOneSubject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrectAnswerForOneSubjectRepository extends JpaRepository<CorrectAnswerForOneSubject,Long> {
}
