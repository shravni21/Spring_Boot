package com.spring.springcoredemo;

import org.springframework.boot.SpringApplication;
// Auto configuration component scanning additional configuration
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@SpringBootApplication(
//        scanBasePackages = {"com.spring.springcoredemo",
//                "com.spring.util"}
//)
@SpringBootApplication
public class SpringCoreDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCoreDemoApplication.class, args);
    }
}
