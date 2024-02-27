package com.spring.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TenisCoach implements Coach {
    public TenisCoach(){
        System.out.println("Constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getDailiyWorkout() {
        return "Practice your backhand valley.";
    }
}
