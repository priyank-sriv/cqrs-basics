package com.cqrs.basics.domain.command;

public class WithdrawMoneyCommand {
    
    public final String id;
    public final double amount;

    public WithdrawMoneyCommand(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }
}
