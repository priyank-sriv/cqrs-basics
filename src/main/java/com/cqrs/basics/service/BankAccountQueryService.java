package com.cqrs.basics.service;

import com.cqrs.basics.datastore.BankAccountStore;
import com.cqrs.basics.domain.aggregate.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountQueryService {

    @Autowired
    private BankAccountStore dataStore;

    public List<BankAccount> findAll() {
        return dataStore.findAll();
    }
    
    public BankAccount findOne(String id) {
        return dataStore.get(id);
    }

    public Double getBalance(String id) {
        return dataStore.getBalance(id);
    }
}
