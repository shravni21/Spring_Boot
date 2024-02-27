package com.spring.springcoredemo.common;

import com.spring.springcoredemo.common.Coach;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//Component notation marks the class as annotation bean
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("Constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getDailiyWorkout() {
        return "Practice fast bowling for 15mins.";
    }
}
