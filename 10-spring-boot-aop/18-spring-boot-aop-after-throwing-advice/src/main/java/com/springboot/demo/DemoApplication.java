package com.springboot.demo;

import com.springboot.demo.dao.AccountDAO;
import com.springboot.demo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        return runner -> {
//            demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
//            demoTheAfterReturningAdvice(theAccountDAO);

            demoTheAfterThrowingingAdvice(theAccountDAO);
        };
    }

    private void demoTheAfterThrowingingAdvice(AccountDAO theAccountDAO) {
        // call method to find the accounts
        List<Account> accountList = null;
        try {
            // add a boolean flag to simulate exception
            boolean tripwire = true;

            theAccountDAO.findAccounts(tripwire);
        } catch (Exception e) {
            System.out.println("Exception ---- caught exception" + e);
        }


        // display the accounts
        System.out.println("\n\n DemoTheAfterRThrowingAdvice");
        System.out.println("---------");

        System.out.println(accountList);
        System.out.println("\n");
    }

    private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
        // call method to find the accounts
        List<Account> accountList = theAccountDAO.findAccounts();

        // display the accounts
        System.out.println("\n\n DemoTheAfterReturnAdvice");
        System.out.println("---------");

        System.out.println(accountList);
        System.out.println("\n");
    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

        // call the business method
        Account account = new Account();
        account.setName("Shravni");
        account.setLevel("10");
        theAccountDAO.addAccount(account, true);
        theAccountDAO.doWork();

        // Call the accountDAO getter/setter methods
        theAccountDAO.setName("Lalit Prabhakar");
        theAccountDAO.setServiceCode("JAVA123");

        System.out.println("The getName is : " + theAccountDAO.getName());
        System.out.println("Service code is: " + theAccountDAO.getServiceCode());


        // call the membership business method
        theMembershipDAO.addAccount();
        theMembershipDAO.goToSleep();

    }
}














