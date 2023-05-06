package com.example.btvn_b5.controller;

import com.example.btvn_b5.entity.Account;
import com.example.btvn_b5.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountServiceImpl accountServiceImpl;

    @GetMapping(value = {"/login", "/"})
    public ModelAndView loginView(){
        ModelAndView view = new ModelAndView("login");
        return view;
    }

    @GetMapping(value = "/register")
    public ModelAndView registerView(){
        ModelAndView view = new ModelAndView("register");
        return view;
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteView(@PathVariable Long id){
        ModelAndView delete = new ModelAndView("delete");
        delete.addObject("id", id);
        return delete;
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView editView(@PathVariable Long id) {
        Account account = accountServiceImpl.getAccountById(id);
        ModelAndView edit = new ModelAndView("edit");
        edit.addObject("account", account);

        return edit;
    }

    @GetMapping(value = "/index")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("index");
        List<Account> accounts = accountServiceImpl.getAllAccounts();
        System.out.println(accounts.toString());
        view.addObject("accounts", accounts);

        return view;
    }

    @GetMapping(value = "/api/accounts")
    public ResponseEntity<?> api(){
        return ResponseEntity.ok().body(accountServiceImpl.getAllAccounts());
    }

    @PostMapping(value = "/index")
    public ModelAndView loginHandler(@RequestParam String username, @RequestParam String password, @RequestParam String fullname){
        if(accountServiceImpl.checkAccountByUsernameAndPassword(username,password)){
            return index();
        } else{
            ModelAndView login = new ModelAndView("login");
            login.addObject("error", "User name is not exits or bad password");
            return login;
        }
    }

    @PostMapping(value = "/register")
    public ModelAndView registerHandler(@RequestParam String username, @RequestParam String password, @RequestParam String fullname){
        if(accountServiceImpl.getAccountByUsername(username) == null){
            accountServiceImpl.createAccount(new Account(username, password, fullname));
            return loginView();
        }
        else{
            ModelAndView register = new ModelAndView("register");
            register.addObject("err", "Username is exits. Please try again with another username");
            return register;
        }
    }

    @PostMapping(value = "user/delete/{id}")
    public ModelAndView deleteAccountHandler(@PathVariable Long id){
        accountServiceImpl.deleteAccountById(id);
        ResponseEntity.ok().body("Successful delete account" + id);
        return index();
    }

    @PostMapping(value = "/edit/{id}")
    public ModelAndView editAccountHandler(@PathVariable Long id, @ModelAttribute Account newAccount){
        accountServiceImpl.updateAccount(id, newAccount);
        ResponseEntity.ok().body("Successfull update account " + id);
        return index();
    }
}









