package com.example.buoi4v2.controller;

import com.example.buoi4v2.Model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    static List<User> userList = new ArrayList<>();

    static
    {
        userList.add(new User(1L,"admin1","1"));
        userList.add(new User(2L,"admin2","1"));
        userList.add(new User(3L,"admin3","1"));
        userList.add(new User(4L,"admin4","1"));
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        User response = null;
        for(User user: userList){
            if(user.getId().equals(id)){
                response = user;
            }
        }
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/user/{username}")
    public ResponseEntity<?> getUser(@PathVariable("username") String username,
//            @RequestParam(name = "username",required = false, defaultValue = "admin2") String username,
            @RequestParam String password) {
        User response = null;
        for(User user: userList){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                response = user;
            }
        }
        return ResponseEntity.ok().body(response);
    }

//    @PostMapping("/body/user")
//    public ResponseEntity<?> createUser(@RequestBody User user){
//        return ResponseEntity.ok().body(user);
//    }
//
//    @PostMapping("/model/user")
//    public ResponseEntity<?> createUser(@ModelAttribute User user){
//        return ResponseEntity.ok().body(user);
//    }
}
