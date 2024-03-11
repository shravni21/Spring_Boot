package com.springboot.onetoone.demo.dao;

import com.springboot.onetoone.demo.entity.Instructor;
import com.springboot.onetoone.demo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);


}
