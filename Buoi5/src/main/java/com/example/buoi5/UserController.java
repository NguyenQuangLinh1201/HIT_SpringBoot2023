package com.example.buoi5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public ResponseEntity<?>createUser(@RequestBody User user){
        User userCreate = userRepository.save(user);

        return ResponseEntity.ok().body(userRepository.save(userCreate));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?>getUseById(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);

        return ResponseEntity.ok().body(user.get());
    }
}
