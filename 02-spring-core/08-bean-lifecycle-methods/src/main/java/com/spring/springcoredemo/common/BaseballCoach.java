package com.spring.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
    public BaseballCoach(){
        System.out.println("Constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getDailiyWorkout() {
        return "Spend 30 mins in batting practice.";
    }
}
