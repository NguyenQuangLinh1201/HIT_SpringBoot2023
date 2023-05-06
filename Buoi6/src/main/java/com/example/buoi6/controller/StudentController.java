package com.example.buoi6.controller;

import com.example.buoi6.dto.StudentDTO;
import com.example.buoi6.model.Student;
import com.example.buoi6.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/create_new_student")
    public ResponseEntity<?> createNewStudent(@RequestBody StudentDTO studentDTO){
        Student student = new Student(studentDTO.getName(), studentDTO.getAddress());

        return ResponseEntity.ok(studentRepository.save(student));
    }

    @GetMapping("/get_all")
    public ResponseEntity<?> getAllStudent(@RequestParam int page, @RequestParam int size){
        Page<Student> students = studentRepository.findAll(PageRequest.of(page,size));
        //trang bắt đầu từ 0, size là số lượng bản ghi
        return ResponseEntity.ok(students.getContent());
    }
}
