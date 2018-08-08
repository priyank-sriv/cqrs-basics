package com.cqrs.basics.api;

import com.cqrs.basics.domain.command.CreateAccountCommand;
import com.cqrs.basics.domain.command.DepositMoneyCommand;
import com.cqrs.basics.domain.command.WithdrawMoneyCommand;
import com.cqrs.basics.service.BankAccountCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping(value = "/api/accounts",
        produces = "application/json;charset=UTF-8",
        consumes = "application/json;charset=UTF-8"
)
public class BankAccountCommandAPI {
    
    @Autowired
    private BankAccountCommandService service;
    
    @PostMapping
    public ResponseEntity<String> createAccount(@RequestBody CreateAccountCommand command) {
        String id = service.createAccount(command);
        return ResponseEntity.created(location("/{id}", id))
                .header("Id", id).build();
    }
    
    @PutMapping(path = "/{accountId}/moneyDeposit")
    public ResponseEntity<Double> depositMoney(@RequestBody DepositMoneyCommand command) {
        return ResponseEntity.ok(service.depositMoney(command));
    }

    @PutMapping(path = "/{accountId}/moneyWithdrawal")
    public ResponseEntity<Double> withdrawMoney(@RequestBody WithdrawMoneyCommand command) {
        return ResponseEntity.ok(service.withdrawMoney(command));
    }

    private static URI location(String path, Object... args) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path(path).buildAndExpand(args).toUri();
    }
}
