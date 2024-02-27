package com.spring.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class TrackCoach implements Coach {
    public TrackCoach(){
        System.out.println("Constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getDailiyWorkout() {
        return "Run hard 5k";
    }
}
