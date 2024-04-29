package com.example.ExamCheckingTool.repository;

import com.example.ExamCheckingTool.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
}
