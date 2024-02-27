package com.spring.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    @Override
    public String getDailiyWorkout() {
        return "Run hard 5k";
    }
}
