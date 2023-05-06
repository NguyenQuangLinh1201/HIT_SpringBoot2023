package com.example.buoi3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//@Controller
@RestController
public class Buoi3Controller {

    @ResponseBody
    @GetMapping("/index")
    public Student index(){
        return "index";
    }
}
