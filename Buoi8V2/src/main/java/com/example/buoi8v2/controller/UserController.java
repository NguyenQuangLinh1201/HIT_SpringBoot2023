package com.example.buoi8v2.controller;

import com.example.buoi8v2.dto.UserDTO;
import com.example.buoi8v2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create_user")
    public ResponseEntity<?> createNewUser(@RequestParam String name, @RequestParam String address, @RequestParam MultipartFile file) throws IOException {
        return ResponseEntity.ok(userService.create(name, address, file));
    }

    @PostMapping("/create_user2")
    public ResponseEntity<?> createNewUser(@ModelAttribute UserDTO userDTO) throws IOException {
        return ResponseEntity.ok(userService.create2(userDTO));
    }

    @PostMapping("/create_user3")
    public ResponseEntity<?> createNewUser3(@RequestParam String name, @RequestParam String address, @RequestParam MultipartFile file) {
        return ResponseEntity.ok(userService.create3(name, address, file));
    }

    Map

}
