package com.spring.springcoredemo.rest;

import com.spring.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // Define private field for the dependency
    private Coach mycoach;

    @Autowired
    public void setCoach(Coach theCoach){
        mycoach= theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return mycoach.getDailiyWorkout();
    }
}
