package com.example.btvn_b6.service;

import com.example.btvn_b6.model.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {
    List<Subject> findSubjectByStudentId(Long id);
}
