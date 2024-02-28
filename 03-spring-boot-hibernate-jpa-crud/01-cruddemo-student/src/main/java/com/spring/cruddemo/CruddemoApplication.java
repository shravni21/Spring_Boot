package com.spring.cruddemo;

import com.spring.cruddemo.dao.StudentDAO;
import com.spring.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            System.out.println("Hello world");
            createStudent(studentDAO);

//            createMultipleStudent(studentDAO);
        };

    }

    private void createMultipleStudent(StudentDAO studentDAO) {

        // Create multiple students
        System.out.println("Creating 3 student objects....");
        Student tempStudent1 = new Student("John", "Doe", "john@gmail.com");
        Student tempStudent2 = new Student("shreya", "Karale", "shreya@gmail.com");
        Student tempStudent3 = new Student("Priya", "Khadsare", "priya@gmail.com");

        // save the student objects
        System.out.println("Saving the students....");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

    }

    private void createStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("Creating new student object....");
        Student tempStudent = new Student("Shravni", "Wakde", "wakdeshravni1@gmail.com");

        // save the student object
        System.out.println("Saving the student....");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved student. generated id: " + tempStudent);

    }
}
