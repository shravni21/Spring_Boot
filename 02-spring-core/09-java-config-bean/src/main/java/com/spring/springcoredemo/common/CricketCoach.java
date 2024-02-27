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

    @Override
    public String getDailiyWorkout() {
        return "Practice fast bowling for 15mins.";
    }
}
