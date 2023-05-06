package com.example.btvn_b5.repository;

import com.example.btvn_b5.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "SELECT * FROM account a WHERE a.username = ?1 AND a.password = ?2", nativeQuery = true)
    Optional<Account> getAccountByUsernameAndPassword(String username, String password);

    @Query(value = "SELECT * FROM account a WHERE a.username = ?1", nativeQuery = true)
    Optional<Account> getAccountByUsername(String username);
}
