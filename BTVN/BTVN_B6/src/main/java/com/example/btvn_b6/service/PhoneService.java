package com.example.btvn_b6.service;

import com.example.btvn_b6.dto.PhoneDTO;
import com.example.btvn_b6.model.Phone;
import org.springframework.stereotype.Service;

@Service
public interface PhoneService {
    Phone findPhoneById(Long id);

    void updatePhone(Long id, PhoneDTO phoneDTO);
}
