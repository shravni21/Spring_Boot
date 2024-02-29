package com.spring.demo.rest;

import com.spring.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudent;

    //Define @PostConstruct to load the student data
    @PostConstruct
    public void loadData() {
        theStudent = new ArrayList<>();

        theStudent.add(new Student("Pornima", "Patel"));
        theStudent.add(new Student("Shravni", "Wakde"));
        theStudent.add(new Student("Nandini", "Indrale"));
        theStudent.add(new Student("Shweta", "Zade"));
    }

    //Define endpoint for "/students" - return the list of students
    @GetMapping("/students")
    public List<Student> getStudent() {
        return theStudent;
    }

    //Define endpoint or "/student/{studentID}"- return student at index
    @GetMapping("/students/{studentID}")
    public Student getStudent(@PathVariable int studentID) {

        // Just index into the list.....keep it simple for now

        // check the studentID against list size

        if (studentID >= theStudent.size() || studentID < 0) {
            throw new StudentNotFoundException("Student is not found! " + studentID);
        }

        return theStudent.get(studentID);

    }




}

