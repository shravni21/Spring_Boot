package com.springboot.demo.dao;


import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public boolean addAccount() {

        System.out.println(getClass() + " Doing my DB work: adding a membership account!!!");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + " I am going to home! bye.");
    }
}
