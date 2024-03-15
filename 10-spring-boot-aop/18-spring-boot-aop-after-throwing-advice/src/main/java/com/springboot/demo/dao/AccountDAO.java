package com.springboot.demo.dao;

import com.springboot.demo.Account;

import java.util.List;

public interface AccountDAO {

    // add a new method: findAccounts()
    List<Account>findAccounts();

    List<Account> findAccounts(Boolean tripWire);

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);



}
