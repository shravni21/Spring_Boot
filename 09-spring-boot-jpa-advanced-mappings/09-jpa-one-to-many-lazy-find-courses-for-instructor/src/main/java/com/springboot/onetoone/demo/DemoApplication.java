package com.springboot.onetoone.demo;

import com.springboot.onetoone.demo.dao.AppDAO;
import com.springboot.onetoone.demo.entity.Course;
import com.springboot.onetoone.demo.entity.Instructor;
import com.springboot.onetoone.demo.entity.InstructorDetail;
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
//            createInstructor(appDAO);
//            findInstructor(appDAO);
//            deleteInstructor(appDAO);
//            findInstructorDetail(appDAO);
//            deleteInstructorDetail(appDAO);
//            createInstructorWithCourses(appDAO);
//            findInstructorWithCourses(appDAO);
            findCoursesForInstructor(appDAO);
        };


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
        int theId = 2;
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







