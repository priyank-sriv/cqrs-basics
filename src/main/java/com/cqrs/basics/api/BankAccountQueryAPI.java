package com.cqrs.basics.api;

import com.cqrs.basics.domain.aggregate.BankAccount;
import com.cqrs.basics.service.BankAccountQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/accounts", 
        produces = "application/json;charset=UTF-8"
)
public class BankAccountQueryAPI {
    
    @Autowired
    private BankAccountQueryService service;
    
    @GetMapping
    public ResponseEntity<List<BankAccount>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> getAccount(@PathVariable String id) {
        return ResponseEntity.ok(service.findOne(id));
    }

    @GetMapping("/{id}/balance")
    public ResponseEntity<Double> getBalance(@PathVariable String id) {
        return ResponseEntity.ok(service.getBalance(id));
    }
}
