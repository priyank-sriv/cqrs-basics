package com.cqrs.basics.domain.command;

public class CreateAccountCommand {

    public final String accountHolder;

    public CreateAccountCommand(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}
