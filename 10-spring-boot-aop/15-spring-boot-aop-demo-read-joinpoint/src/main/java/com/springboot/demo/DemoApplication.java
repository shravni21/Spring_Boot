package com.springboot.demo;

import com.springboot.demo.dao.AccountDAO;
import com.springboot.demo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        return runner -> {
            demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);

        };
    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

        // call the business method
        Account account= new Account();
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














