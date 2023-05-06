package com.example.btvn_b6.service.impl;

import com.example.btvn_b6.dto.StudentDTO;
import com.example.btvn_b6.exception.InternalServerException;
import com.example.btvn_b6.exception.NotFoundException;
import com.example.btvn_b6.model.Student;
import com.example.btvn_b6.repository.StudentRepository;
import com.example.btvn_b6.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student findStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() ->{
            throw new NotFoundException("Not found student ID" + id);
        });
    }

    @Override
    public void updateStudent(Long id, StudentDTO studentDTO) {
        try{
            studentRepository.updateStudent(id, studentDTO.getName(), studentDTO.getAddress());
        } catch(Exception e){
            throw new InternalServerException("Update student error");
        }
    }

    @Override
    public void deleteStudentById(Long id) {
        Optional<Student> studentFind = studentRepository.findById(id);

        if(studentFind.isEmpty()){
            throw new NotFoundException("Not found student ID" + id);
        }

        try{
            studentRepository.deleteById(id);
        } catch(Exception e){
            throw new InternalServerException("Delete student error");
        }
    }
}
