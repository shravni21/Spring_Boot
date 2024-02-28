package com.spring.cruddemo.dao;

import com.spring.cruddemo.entity.Student;

import java.util.List;

//Step 1: create new interface Student DAO
public interface StudentDAO {
    void save(Student TheStudent);

    Student FIndbyId(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);
}
