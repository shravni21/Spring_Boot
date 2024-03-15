package com.springboot.demo.aspect;


import com.springboot.demo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.List;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

    // add a new advice for @AfterReturning on the findAccount method
    @AfterReturning(
            pointcut = "execution(* com.springboot.demo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toString();
        System.out.println("\n ======> @AfterReturning  on method: " + method);

        // print out the results of the method
        System.out.println("\n =======> result is: " + result);


        // let's process the data.... let's modify it:

        // cover the account names to uppercase
        convertAccountNamesToUpperCase(result);
        System.out.println("\n =======> result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        // loop through accounts
        for (Account it : result) {
            // get uppercase
            String Upper_case = it.getName().toUpperCase();
            // update the names on the account
            it.setName(Upper_case);
        }

    }

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

