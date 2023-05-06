package com.example.btvn_b6.controller;

import com.example.btvn_b6.dto.PhoneDTO;
import com.example.btvn_b6.model.Phone;
import com.example.btvn_b6.model.Student;
import com.example.btvn_b6.repository.PhoneRepository;
import com.example.btvn_b6.service.PhoneService;
import com.example.btvn_b6.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phones")
public class PhoneController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private PhoneService phoneService;

    @GetMapping("")
    public ResponseEntity<?> getListPhone(){
        return ResponseEntity.ok(phoneRepository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPhone(@RequestBody PhoneDTO phoneDTO){
        Student student = studentService.findStudentById(phoneDTO.getStudent_id());

        Phone phone = new Phone(phoneDTO.getName(), phoneDTO.getBrand(), student);

        return ResponseEntity.ok(phoneRepository.save(phone));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updatePhone(@PathVariable Long id, @RequestBody PhoneDTO phoneDTO){
        phoneService.updatePhone(id, phoneDTO);
        return ResponseEntity.ok().build();
    }
}
