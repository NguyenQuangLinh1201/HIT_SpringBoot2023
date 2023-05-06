package com.example.btvn_b5.service;

import com.example.btvn_b5.entity.Account;

import java.util.List;

public interface AccountService {
    //Create
    Account createAccount(Account account);

    //Read
    List<Account> getAllAccounts();
    Account getAccountById(Long id);
    Account getAccountByUsername(String username);
    Boolean checkAccountByUsernameAndPassword(String username, String password);

    //Delete
    void deleteAccountById(Long id);

    //Update
    Account updateAccount(Long id, Account newAccount);
}
