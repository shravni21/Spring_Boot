package com.springboot.demo.dao;


import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    @Override
    public void addAccount() {

        System.out.println(getClass() + " Adding an account.....");
    }
}
