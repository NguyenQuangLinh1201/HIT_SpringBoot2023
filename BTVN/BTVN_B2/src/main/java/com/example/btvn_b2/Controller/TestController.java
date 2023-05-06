package com.example.btvn_b2.Controller;


import com.example.btvn_b2.Model.Account;
import com.example.btvn_b2.Model.Student;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.JstlUtils;

import java.util.LinkedList;
import java.util.List;

//@Controller
@RestController
public class TestController {


    @GetMapping("/index")
    public ResponseEntity<Student> index(){
        Student student = new Student(03,"linh", 20, "cntt");
        return ResponseEntity.ok().body(student);
//        return ResponseEntity.ok().build; trả về 1 mess
    }
//    @ResponseBody
//    @GetMapping("/index")
//    public Student index(){
//        Student student = new Student(03,"linh", 20, "cntt");
//        return student;
//    }
    @RequestMapping(value = "/index")
    public ModelAndView index(Model model){
        ModelAndView view = new ModelAndView("index");

        return view;
    }

    public boolean checkAccount(Account a){
        List<Account> accountList = new LinkedList<>();
        accountList.add(new Account("linh", "a"));
        accountList.add(new Account("minh", "a"));
        accountList.add(new Account("quang", "a"));
        for (Account acount: accountList) {
            if(a.getUsername().equals(acount.getUsername()) && a.getPassword().equals(acount.getPassword())){
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/about", method = RequestMethod.POST)
    public String about(@ModelAttribute Account a, Model model){
        List<Student> studentList = new LinkedList<>();
        studentList.add(new Student(001,"Nguyễn Văn A", 18, "CNTT"));
        studentList.add(new Student(002,"Nguyễn Văn B", 19, "CNTT"));
        studentList.add(new Student(003,"Nguyễn Văn C", 20, "CNTT"));

        if(checkAccount(a)){
            model.addAttribute("students", studentList);
            return "redirect:about";
        }

        return "redirect:reLogin";
    }
}

