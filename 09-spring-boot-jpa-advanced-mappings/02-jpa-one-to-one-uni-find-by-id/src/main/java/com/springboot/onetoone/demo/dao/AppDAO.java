package com.springboot.onetoone.demo.dao;

import com.springboot.onetoone.demo.entity.Instructor;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
}
