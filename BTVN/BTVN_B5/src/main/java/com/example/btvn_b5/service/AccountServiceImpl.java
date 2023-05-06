package com.example.btvn_b5.service;

import com.example.btvn_b5.entity.Account;
import com.example.btvn_b5.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account){
        if(account.getFullname() == null || account.getFullname().isEmpty()){
            return null;
        }
        if(account.getUsername() == null || account.getUsername().isEmpty()){
            return null;
        }
        if(account.getPassword() == null || account.getPassword().isEmpty()) {
            return null;
        }
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account getAccountByUsername(String username) {
        return accountRepository.getAccountByUsername(username).orElse(null);
    }

    @Override
    public Boolean checkAccountByUsernameAndPassword(String username, String password) {
        Optional<Account> a = accountRepository.getAccountByUsernameAndPassword(username, password);
        return a.isPresent();
    }

    @Override
    public void deleteAccountById(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account updateAccount(Long id, Account newAccount) {
        Account a = accountRepository.findById(id).orElse(null);
        if(a == null){
            return null;
        }
        a.setUsername(newAccount.getUsername());
        a.setPassword(newAccount.getPassword());
        a.setFullname(newAccount.getFullname());
        return accountRepository.save(a);
    }
}
