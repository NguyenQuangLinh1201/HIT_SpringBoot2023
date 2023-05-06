package com.example.buoi5;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    @Query("SELECT u FROM User u WHERE " +
            "u.id = ?1 AND u.username = ?2") //JPQLQuery
    User findUser(Long id, String username);

    @Query(value = "SELECT * FROM users " +
            "WHERE id = ?1 AND full_name = ?2",
            nativeQuery = true) //NativeQuery;
    User findUserNative(Long id, String username);

}
