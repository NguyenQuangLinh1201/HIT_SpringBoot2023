package com.example.btvn_b6.service.impl;

import com.example.btvn_b6.exception.NotFoundException;
import com.example.btvn_b6.model.Student;
import com.example.btvn_b6.model.Subject;
import com.example.btvn_b6.repository.SubjectRepository;
import com.example.btvn_b6.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubjectServiceImpl  implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> findSubjectByStudentId(Long id) {
        List<Subject> subjectList = subjectRepository.findSubjectsByStudent(id);

        if(subjectList.isEmpty()){
            throw new NotFoundException("Not Found Subject by ID " + id);
        }

        return subjectList;
    }
}
