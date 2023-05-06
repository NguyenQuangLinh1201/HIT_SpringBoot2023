package com.example.btvn_b6.repository;

import com.example.btvn_b6.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Student s SET s.name = ?2, s.address = ?3 WHERE s.id = ?1")
    void updateStudent(Long id, String name, String address);
}
