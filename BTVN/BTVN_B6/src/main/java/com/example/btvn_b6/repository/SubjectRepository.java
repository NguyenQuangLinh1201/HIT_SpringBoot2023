package com.example.btvn_b6.repository;

import com.example.btvn_b6.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    @Transactional
    @Modifying
    @Query("SELECT s.name FROM Subject s WHERE s.student.id = ?1")
    List<Subject> findSubjectsByStudent(Long id);
}