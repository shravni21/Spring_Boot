package com.springboot.demo.dao;


import com.springboot.demo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account theAccount) {

        System.out.println(getClass() + " Adding an account.....");
    }
}
