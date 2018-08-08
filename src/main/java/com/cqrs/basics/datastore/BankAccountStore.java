package com.cqrs.basics.datastore;

import com.cqrs.basics.domain.aggregate.BankAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Service
public class BankAccountStore {
    
    private static final Map<String, BankAccount> bankAccounts = new ConcurrentHashMap<>();
    
    public void put(BankAccount bankAccount) {
        bankAccounts.put(bankAccount.getId(), bankAccount);
    }
    
    public BankAccount get(String id) {
        return bankAccounts.get(id);
    }
    
    public double updateBalance(String id, double amount) {
        return bankAccounts.computeIfPresent(id, (k, v) -> 
                new BankAccount(v.getId(), v.getBalance() + amount, v.getAccountHolder())).getBalance();
    }
    
    public List<BankAccount> findAll() {
        return Collections.unmodifiableList(new ArrayList<>(bankAccounts.values()));
    }
    
    public Double getBalance(String id) {
        return bankAccounts.get(id).getBalance();
    }
}
