package com.springboot.onetoone.demo;

import com.springboot.onetoone.demo.dao.AppDAO;
import com.springboot.onetoone.demo.entity.Instructor;
import com.springboot.onetoone.demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
            deleteInstructorDetail(appDAO);
        };

    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Deleting the instructor detail id" + theId);
        appDAO.deleteInstructorById(theId);
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







