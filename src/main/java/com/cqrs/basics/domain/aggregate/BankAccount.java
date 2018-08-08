package com.cqrs.basics.domain.aggregate;

import java.io.Serializable;


public class BankAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private double balance;
    private String accountHolder;

    public BankAccount(String id, double balance, String accountHolder) {
        this.id = id;
        this.balance = balance;
        this.accountHolder = accountHolder;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}
