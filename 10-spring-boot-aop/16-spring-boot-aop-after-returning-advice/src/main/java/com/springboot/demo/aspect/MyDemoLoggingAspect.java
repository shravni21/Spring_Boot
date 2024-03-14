package com.springboot.demo.aspect;


import com.springboot.demo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

    @Before("com.springboot.demo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n =========> Executing @Before advice on method.... \n");
        // display the method signature
        MethodSignature methodSignature = (MethodSignature)
                joinPoint.getSignature();

        // display method arguments
        System.out.println("Method : " + methodSignature);

        // get args
        Object[] args = joinPoint.getArgs();

        // loop through args
        for (Object it : args) {
            System.out.println(it);
            if (it instanceof Account) {
                // downcast and print account specific stuff
                Account account = (Account) it;

                System.out.println("Account name: " + account.getName());
                System.out.println("Account name: " + account.getLevel());
            }
        }

    }


}

