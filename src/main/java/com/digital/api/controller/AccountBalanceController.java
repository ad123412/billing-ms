package com.digital.api.controller;

import com.digital.api.model.AccountBalance;
import com.digital.api.model.AccountRelationship;
import com.digital.api.service.AccountBalanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class AccountBalanceController {

    @Autowired
    private AccountBalanceServiceImpl accountBalanceService;

    @GetMapping(value = {"/account/balance/{id}"})
    public Flux<AccountBalance> getAccountBalanceDetails(@PathVariable(value = "id") String accountBalanceId){

        return Flux.just(accountBalanceService.getAccountBalanceById(accountBalanceId))
                .filter(accountBalanceOptional -> accountBalanceOptional.isPresent())
                .map(accountBalanceOptional -> accountBalanceOptional.get());
    }

    @GetMapping(value = {"/account/relationship/{id}"})
    public Flux<AccountRelationship> getBillStructureDetails(@PathVariable(value = "id") String accountRelationshipId){

        return Flux.just(accountBalanceService.getAccountRelationshipById(accountRelationshipId))
                .filter(accountRelationshipOptional -> accountRelationshipOptional.isPresent())
                .map(accountRelationshipOptional -> accountRelationshipOptional.get());
    }
}
