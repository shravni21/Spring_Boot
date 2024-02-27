package com.spring.springcoredemo.common;

public class SwimCoach implements Coach {
    public SwimCoach(){
        System.out.println("Constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getDailiyWorkout() {
        return "Swim 1000 meters as a warm up.";
    }
}
