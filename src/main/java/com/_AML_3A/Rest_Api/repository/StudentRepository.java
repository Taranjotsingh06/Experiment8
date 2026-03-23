package com._AML_3A.Rest_Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com._AML_3A.Rest_Api.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{
}