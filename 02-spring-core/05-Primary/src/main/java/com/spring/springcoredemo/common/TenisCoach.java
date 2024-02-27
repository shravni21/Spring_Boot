package com.spring.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TenisCoach implements Coach {
    @Override
    public String getDailiyWorkout() {
        return "Practice your backhand valley.";
    }
}
