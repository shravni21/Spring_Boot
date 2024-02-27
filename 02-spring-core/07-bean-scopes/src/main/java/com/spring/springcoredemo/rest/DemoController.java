package com.spring.springcoredemo.rest;

import com.spring.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // Define private field for the dependency
    private Coach mycoach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach, @Qualifier("cricketCoach") Coach theanotherCoach) {
        System.out.println("Constructor: " + getClass().getSimpleName());
        mycoach = theCoach;
        anotherCoach = theanotherCoach;

    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return mycoach.getDailiyWorkout();
    }

    @GetMapping("/check")
    public String Check() {
        return "Comparing beans: myCoach==anotherCoach, " + (mycoach == anotherCoach);
    }
}
