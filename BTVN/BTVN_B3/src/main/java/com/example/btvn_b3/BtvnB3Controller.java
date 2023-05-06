package com.example.btvn_b3;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BtvnB3Controller {

    @GetMapping({"/", "/login"})
    public String index(){

        return "index";
    }

    @GetMapping("/store")
    public String store(Model model){
        model.addAttribute("list", Store.userList);
        return "store";
    }

    @PostMapping("/login")
    public String loginRedirect(@ModelAttribute User user, Model model){
        List<User> userList = Store.getUserList();
//        for(User item : userList){
//            if(item.getUsername().equals(user.getUsername()) && item.getPassword().equals(user.getPassword()))
                return "redirect:/store";
//        }
//        return "loginFailed";
    }

    @GetMapping("/api/users")
    public ResponseEntity<?> getAPI(Model model){
        return ResponseEntity.ok().body(Store.userList);
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam("username") String username, @RequestParam("password") String password){
        for(User user : Store.userList){
            if(user.getUsername().equals(username))
                return "signupFailed";
        }
        Store.userList.add(new User(username,password));
        return "redirect:login";
    }
//    @GetMapping({"/","/login"})
//    public String index() {
//        return "index";
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
//        for(User user : Store.getUserList()){
//            if (username.equals(user.getUsername()) && password.equals(user.getPassword()))
//                return "redirect:/store";
//        }
//        return "loginFailed";
//    }
//
//    @GetMapping("/store")
//    public String about(Model model) {
//        model.addAttribute("list", Store.getUserList());
//        return "store";
//    }
//
//    @GetMapping("/user")
//    @ResponseBody
//    public List<User> getAllUser(){
//        return Store.getUserList();
//    }
//
//    @GetMapping("/signup")
//    public String signup(){
//        return "signup";
//    }
//
//    @PostMapping("/signup")
//    public String signup(User user){
//        Store.getUserList().add(user);
//        return "redirect:/store";
//    }
}
