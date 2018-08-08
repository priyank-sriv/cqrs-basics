package com.cqrs.basics.service;


import com.cqrs.basics.datastore.BankAccountStore;
import com.cqrs.basics.domain.aggregate.BankAccount;
import com.cqrs.basics.domain.command.CreateAccountCommand;
import com.cqrs.basics.domain.command.DepositMoneyCommand;
import com.cqrs.basics.domain.command.WithdrawMoneyCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class BankAccountCommandService {
    
    @Autowired
    private BankAccountStore dataStore;
    
    public String createAccount(CreateAccountCommand command) {
        String id = UUID.randomUUID().toString();
        BankAccount bankAccount = new BankAccount(id, 
                ThreadLocalRandom.current().nextDouble(1000d, 50_000), 
                "User-" + command.getAccountHolder());
        dataStore.put(bankAccount);
        return id;
    }
    
    public Double depositMoney(DepositMoneyCommand command) {
        return dataStore.updateBalance(command.getId(), command.getAmount());
    }

    public Double withdrawMoney(WithdrawMoneyCommand command) {
        return dataStore.updateBalance(command.getId(), -command.getAmount());
    }
}
