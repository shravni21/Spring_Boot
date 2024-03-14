package com.springboot.demo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where we all of our related advices for logging

    // let's start with a @Before advice

    @Pointcut("execution(* com.springboot.demo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Before("forDaoPackage()")

    public void beforeAddAccountAdvice() {
        System.out.println("\n  ........Executing @Before advice on method........");
    }

}
