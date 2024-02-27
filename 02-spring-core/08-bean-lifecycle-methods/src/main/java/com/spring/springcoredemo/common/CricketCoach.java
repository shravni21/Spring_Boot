package com.spring.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

//Component notation marks the class as annotation bean
@Component

public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("Constructor: "+ getClass().getSimpleName());
    }

    // Define our init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStartupStuff(): "+ getClass().getSimpleName());
    }
    // Define our destroy method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In doMyStartupStuff(): "+ getClass().getSimpleName());
    }
    @Override
    public String getDailiyWorkout() {
        return "Practice fast bowling for 15mins.";
    }
}
