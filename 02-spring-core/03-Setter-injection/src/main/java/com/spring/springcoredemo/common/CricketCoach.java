package com.spring.springcoredemo.common;

import com.spring.springcoredemo.common.Coach;
import org.springframework.stereotype.Component;

//Component notation marks the class as annotation bean
@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailiyWorkout() {
        return "Practice fast bowling for 15mins.";
    }
}
