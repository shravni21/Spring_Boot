package com.spring.cruddemo.dao;

import com.spring.cruddemo.entity.Student;

//Step 1: create new interface Student DAO
public interface StudentDAO {
    void save(Student TheStudent);
}