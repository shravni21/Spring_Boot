package com.springboot.onetoone.demo;

import com.springboot.onetoone.demo.dao.AppDAO;
import com.springboot.onetoone.demo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return runner -> {
//            createCourseAndStudents(appDAO);
//            findCourseAndStudents(appDAO);
//            findStudentAndCourses(appDAO);
//            addMoreCoursesForStudents(appDAO);
//            deleteCourse(appDAO);
            deleteStudent(appDAO);
        };

    }

    private void deleteStudent(AppDAO appDAO) {
        int id = 1;
        System.out.println("Deleting student with id: " + id);

        appDAO.deleteStudentById(id);
        System.out.println("Student deleted!");
    }

    private void addMoreCoursesForStudents(AppDAO appDAO) {
        int id = 1;

        System.out.println("Finding student with id: " + id);
        Student student = appDAO.findStudentAndCoursesByStudentId(id);

        student.addCourse(new Course("Python"));
        student.addCourse(new Course("C++"));

        System.out.println("Updating student");
        appDAO.update(student);

        System.out.println("Student updated!");
    }

    private void findStudentAndCourses(AppDAO appDAO) {
        int theId = 2;
        Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

        System.out.println("Loaded student: " + tempStudent);
        System.out.println("Courses: " + tempStudent.getCourses());

        System.out.println("Done!");
    }

    private void findCourseAndStudents(AppDAO appDAO) {
        int theId = 10;
        Course tempCourse = appDAO.findCourseAndStudentByCourseId(theId);
        System.out.println("Loades course: " + tempCourse);
        System.out.println("Students: " + tempCourse.getStudents());

        System.out.println("Done!");
    }

    private void createCourseAndStudents(AppDAO appDAO) {
        System.out.println("Creating course and students...");

        // create a course
        Course course = new Course("Java");

        // create the students and add
        course.addStudent(new Student("John", "Doe", "test@email.com"));
        course.addStudent(new Student("Mary", "Public", "test2@email.com"));

        // save the course and associated students
        System.out.println("Saving course: " + course);
        System.out.println("Students: " + course.getStudents());

        appDAO.save(course);
        System.out.println("Done!");
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {
        int id = 10;
        System.out.println("Deleting course with id: " + id + "...");

        appDAO.deleteCourseById(id);
        System.out.println("Course deleted!");
    }


    private void retrieveCourseAndReviews(AppDAO appDAO) {
        // get the course and reviews
        int theId = 10;
        Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

        // print the course
        System.out.println(tempCourse);

        // print the reviews
        System.out.println(tempCourse.getReviews());

        System.out.println("Done!");
    }

    private void createCourseAndReviews(AppDAO appDAO) {
        // create a course
        Course tempCourse = new Course("Ola: the hello to the world");

        // add some reviews
        tempCourse.addReview(new Review("Great course!"));
        tempCourse.addReview(new Review("Loved it!"));
        tempCourse.addReview(new Review("I will suggest to the jrs!"));
        tempCourse.addReview(new Review("It takes much time to complete!"));

        // save the course ........and leverage the cascade all
        System.out.println("Saving the course.");
        System.out.println(tempCourse);
        System.out.println(tempCourse.getReviews());

        appDAO.save(tempCourse);

        System.out.println("Done!");

    }

    private void deleteCourse(AppDAO appDAO) {
        int theId = 11;
        System.out.println("Deleting the course : " + theId);
        appDAO.deleteCourseById(theId);
        System.out.println("Done!");
    }

    private void updateCourse(AppDAO appDAO) {
        int theId = 10;

        // find the course
        System.out.println("Finding the course id: " + theId);
        Course tempCourse = appDAO.findCourseById(theId);

        // Update the course
        System.out.println("Updating the course id: " + theId);
        tempCourse.setTitle("Enjoy the simple things.");

        appDAO.update(tempCourse);
        System.out.println("Done!");
    }

    private void updateInstructor(AppDAO appDAO) {
        int theId = 1;
        // find the instructor
        System.out.println("Finding the instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);

        // update the instructor
        System.out.println("Updating instructor id: " + theId);
        tempInstructor.setLastName("Loki");

        appDAO.update(tempInstructor);
        System.out.println("Done!");
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int theid = 1;

        // find the instructor
        System.out.println("Finding the instructor id: " + theid);

        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theid);

        System.out.println("TempInstructor: " + tempInstructor);
        System.out.println("The associated courses: " + tempInstructor.getCourses());

        System.out.println("Done!");
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int theId = 1;
        // FInd instructor:
        System.out.println("Finding instructor Id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);

        // find courses for instructor
        System.out.println("Finding courses for instructor id: " + theId);
        List<Course> courses = appDAO.findCoursesByInstructorId(theId);

        // Associate the objects
        tempInstructor.setCourses(courses);

        System.out.println("The associated courses: " + tempInstructor.getCourses());

        System.out.println("Done!");
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor Id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("The associated courses: " + tempInstructor.getCourses());

        System.out.println("Done!");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        // Create the instructor
        Instructor tempInstructor = new Instructor("susan", "Pandit", "sp12@gmail.com");

        // Create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube.com", "Video Games!");

        // Associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // create some courses
        Course tempCourse1 = new Course("Java-Beginner course");
        Course tempCourse2 = new Course("C++-Beginner course");
        Course tempCourse3 = new Course("dotNet-Beginner course");
        Course tempCourse4 = new Course("Data Structures and Algorithms");

        // Add courses to instructor
        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);
        tempInstructor.add(tempCourse3);
        tempInstructor.add(tempCourse4);

        // save the instructor
        //
        // Note: this will also save the courses because of CascadeType.persist
        System.out.println("Saving instructor: " + tempInstructor);
        System.out.println("The courses: " + tempInstructor.getCourses());
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int theId = 3;
        System.out.println("Deleting the instructor detail id " + theId);

        appDAO.deleteInstructorDetailById(theId);
        System.out.println("Done!");
    }

    private void findInstructorDetail(AppDAO appDAO) {

        // get the instructor detail object
        int theId = 1;
        InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

        // print the instructor
        System.out.println("TempInstructorDetail: " + tempInstructorDetail);

        // print the associated instructor
        System.out.println("The associated instructor: " + tempInstructorDetail.getInstructor());

        System.out.println("Done!");
    }

    private void deleteInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Deleting instructor id: " + theId);
        appDAO.deleteInstructorById(theId);
        System.out.println("Deleted!");
    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 2;
        System.out.println("finding instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("Temp instructor: " + tempInstructor);
        System.out.println("The associated instructorDetail only: " + tempInstructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {
      /*  // Create the instructor
        Instructor tempInstructor = new Instructor("Shravni", "Wakde", "shravni@gmail.com");

        // Create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube.com", "Chocolate making!!");    */

        // Create the instructor
        Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu12@gmail.com");

        // Create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube.com", "Guitar!");

        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // Save the instructor
        //
        // NOTE: this will also save the details object
        // because of CascadeType.ALL
        //
        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }

}







