package com.example.buoi6.controller;

import com.example.buoi6.dto.SubjectDTO;
import com.example.buoi6.model.Student;
import com.example.buoi6.model.Subject;
import com.example.buoi6.repository.StudentRepository;
import com.example.buoi6.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/create_new_subject")
    public ResponseEntity<?> createNewStudent(@RequestBody SubjectDTO subjectDTO){
        Student student = studentRepository.findById(subjectDTO.getStudent_id()).orElseThrow(
                ()->{
                    System.out.println("Not found student with id " + subjectDTO.getStudent_id());
                    return null;
                }
        );

        Subject subject = new Subject(subjectDTO.getName(), student);

        return ResponseEntity.ok(subjectRepository.save(subject));
    }

    @GetMapping("/get_all_subject")
    public ResponseEntity<?> getAllSubject(){
        return ResponseEntity.ok(subjectRepository.findAll());
    }
}
