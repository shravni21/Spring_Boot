package com.springboot.demo.dao;


import com.springboot.demo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;
    private String serviceCode;


    @Override
    public List<Account> findAccounts() {
        List<Account> myAccounts = new ArrayList<>();
        // create sample accounts
        Account temp = new Account("John", "beginner");
        Account temp2 = new Account("Rehan", "Expert");
        Account temp3 = new Account("Saie", "okay");

        // add them to our list
        myAccounts.add(temp2);
        myAccounts.add(temp);
        myAccounts.add(temp3);

        return myAccounts;
    }

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {

        System.out.println(getClass() + " Adding an account.....");
    }

    @Override
    public boolean doWork() {

        System.out.println("Let's check will it work or not!!" + getClass() + " doWork() ");
        return false;
    }

    public String getName() {
        System.out.println("Let's check will it work or not!!" + getClass() + " In get name ");
        return name;
    }

    public void setName(String name) {
        System.out.println("Let's check will it work or not!!" + getClass() + " In set name ");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println("Let's check will it work or not!!" + getClass() + "  in get Service ");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("Let's check will it work or not!!" + getClass() + " in set Service");
        this.serviceCode = serviceCode;
    }

}
