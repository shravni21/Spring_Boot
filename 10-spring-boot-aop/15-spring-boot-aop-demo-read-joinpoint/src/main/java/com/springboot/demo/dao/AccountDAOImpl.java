package com.springboot.demo.dao;


import com.springboot.demo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;
    private String serviceCode;



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
