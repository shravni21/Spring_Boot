package com.spring.demo.rest;

import com.spring.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    //Define endpoint for "/students" - return the list of students
    @GetMapping("/students")
    public List<Student> getStudent() {
        List<Student> theStudent = new ArrayList<>();
        theStudent.add(new Student("Pornima", "Patel"));
        theStudent.add(new Student("Shravni", "Wakde"));
        theStudent.add(new Student("Nandini", "Indrale"));
        theStudent.add(new Student("Shweta", "Zade"));

        return theStudent;
    }

}
