package com.example.buoi6.repository;

import com.example.buoi6.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Page findAllByName();
}
