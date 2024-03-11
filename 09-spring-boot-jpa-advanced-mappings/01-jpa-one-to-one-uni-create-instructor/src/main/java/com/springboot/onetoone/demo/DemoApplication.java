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
            createInstructor(appDAO);
        };
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







