package com.example.btvn_b6.service.impl;

import com.example.btvn_b6.dto.PhoneDTO;
import com.example.btvn_b6.exception.InternalServerException;
import com.example.btvn_b6.exception.NotFoundException;
import com.example.btvn_b6.model.Phone;
import com.example.btvn_b6.model.Student;
import com.example.btvn_b6.repository.PhoneRepository;
import com.example.btvn_b6.repository.StudentRepository;
import com.example.btvn_b6.service.PhoneService;
import com.example.btvn_b6.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PhoneServiceImpl  implements PhoneService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public Phone findPhoneById(Long id) {
        return phoneRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found Phone by id" + id);
        });
    }

    @Override
    public void updatePhone(Long id, PhoneDTO phoneDTO) {
        Phone phoneFind = this.findPhoneById(id);
        Student studentFind = studentService.findStudentById(phoneDTO.getStudent_id());
        if(studentFind.getPhone() != null){
            Phone phoneFindExist = this.findPhoneById(studentFind.getPhone().getId());
            phoneFindExist.setStudent(null);
        }
        try{
            phoneRepository.updatePhone(id, phoneDTO.getName(), phoneDTO.getBrand(), phoneDTO.getStudent_id());
        } catch (Exception e){
            throw new InternalServerException("Error phone");
        }
    }
}
