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
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(Boolean tripWire) {
        // simulate an exception
        if (tripWire) {
            throw new RuntimeException("Fine! Exception occured!");
        }

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Shravni", "Silver"));
        accounts.add(new Account("Rehan", "Gold"));
        accounts.add(new Account("Piku", "Bronze"));
        return accounts;
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
