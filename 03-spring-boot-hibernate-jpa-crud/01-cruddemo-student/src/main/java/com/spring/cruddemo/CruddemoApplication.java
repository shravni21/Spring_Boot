package com.spring.cruddemo;

import com.spring.cruddemo.dao.StudentDAO;
import com.spring.cruddemo.entity.Student;
import org.hibernate.sql.Update;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            System.out.println("Hello world");

//            createStudent(studentDAO);

//            createMultipleStudent(studentDAO);

//            readStudents(studentDAO);

//            queryForStudents(studentDAO);

//            queryForStudentsByLastName(studentDAO);

//            UpdateStudent(studentDAO);

//            deleteStudent(studentDAO);

            deleteAllStudents(studentDAO);
        };

    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all the students.");
        int numRowsDeleted= studentDAO.deleteAll();
        System.out.println("Deleted rows count: "+ numRowsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int StudentId = 3;
        System.out.println("Deleting student id: " + StudentId);
        studentDAO.delete(StudentId);
    }

    private void UpdateStudent(StudentDAO studentDAO) {

        // Retrieve student based on primary key
        int StudentId = 1;
        System.out.println("Getting student with id: " + StudentId);
        Student myStudent = studentDAO.FIndbyId(StudentId);

        // Change first name
        System.out.println("Updating student....");
        myStudent.setFirst_name("Shinchan");
//        myStudent.setLast_name("Nohara");
//        myStudent.setEmail("shiro@gmail.com");
        studentDAO.Update(myStudent);

        // update the student
        studentDAO.Update(myStudent);

        // display the updated student
        System.out.println("Updated student: " + myStudent);

    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {

        // get a list of students
        List<Student> theStudents = studentDAO.findByLastName("Wakde");

        // display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }

    }

    private void queryForStudents(StudentDAO studentDAO) {
        // get list of students
        List<Student> theStudents = studentDAO.findAll();
        // display list of students
        for (Student temp : theStudents) {
            System.out.println(temp);
        }

    }

    private void readStudents(StudentDAO studentDAO) {
        // Create a student object
        System.out.println("Creating new student object....");
        Student tempstudent = new Student("Mickey", "Mouse", "clubhouse@gmail.com");

        // save the student
        System.out.println("Saving the student...");
        studentDAO.save(tempstudent);

        // display id of the saved student
        int theId = tempstudent.getId();
        System.out.println("Saved student. generated id: " + theId);

        // retrieve student based on the id: primary key
        System.out.println("Retrieving student with id: " + theId);
        Student mystudent = studentDAO.FIndbyId(theId);

        // display student
        System.out.println("Found the student: " + mystudent);
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
