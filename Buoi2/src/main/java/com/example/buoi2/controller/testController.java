package com.example.buoi2.controller;

import com.example.buoi2.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
public class testController {
    @RequestMapping(value = "/home")
    public String index(Model model){
        Student student = new Student(1 , "Linh" , 21);
        Student student2 = new Student(2 , "Minh" , 21);
        List<Student> studentList = new LinkedList<>();
        studentList.add(student);
        studentList.add(student2);

//        model.addAttribute("string", student.toString());
//        model.addAttribute("string2", "2345678");
        model.addAttribute("student", student);
        ModelAndView modelAndView = new ModelAndView("index");
        return "index";
    }
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public  String about(@RequestParam("search") String search, Model model){
        model.addAttribute("search", search);
        return "about";
    }
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test(@ModelAttribute Student student, Model model){
        model.addAttribute("student", student);
        return "test";
    }
}

