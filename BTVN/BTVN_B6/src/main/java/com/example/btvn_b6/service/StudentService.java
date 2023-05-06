package com.example.btvn_b6.service;

import com.example.btvn_b6.dto.StudentDTO;
import com.example.btvn_b6.model.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    Student findStudentById(Long id);

    void updateStudent(Long id, StudentDTO studentDTO);

    void deleteStudentById(Long id);
}
