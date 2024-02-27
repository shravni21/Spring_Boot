package com.spring.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // Define private field for the dependency
    private Coach mycoach;

    //Define constructor for dependency injection
    @Autowired // if only one constructor the its optional
    public DemoController(Coach theCoach) {
        mycoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return mycoach.getDailiyWorkout();
    }
}
