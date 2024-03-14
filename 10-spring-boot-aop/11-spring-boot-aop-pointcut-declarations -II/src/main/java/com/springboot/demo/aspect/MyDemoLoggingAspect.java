package com.springboot.demo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.springboot.demo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Before("forDaoPackage()")

    public void beforeAddAccountAdvice() {
        System.out.println("\n  ........Executing @Before advice on method........");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics(){
        System.out.println("\n =======> Performing API analytics!!");
    }
}
