package com.ex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
