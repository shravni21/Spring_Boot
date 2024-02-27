package com.spring.springcoredemo.config;

import com.spring.springcoredemo.common.Coach;
import com.spring.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.PublicKey;

// Step1
@Configuration
public class SportConfig {

    @Bean ("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }

}
