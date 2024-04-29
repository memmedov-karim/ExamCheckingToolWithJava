package com.example.ExamCheckingTool.repository;

import com.example.ExamCheckingTool.entity.FieldInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FieldInfoRepository extends JpaRepository<FieldInfo,Long> {

    List<FieldInfo> findAllByIdIn(List<Long> ids);
}
