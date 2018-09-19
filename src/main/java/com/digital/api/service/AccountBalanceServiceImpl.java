package com.digital.api.service;

import com.digital.api.model.AccountBalance;
import com.digital.api.model.AccountRelationship;
import com.digital.api.repository.AccountBalanceRepository;
import com.digital.api.repository.AccountRelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountBalanceServiceImpl implements AccountBalanceService {

    @Autowired
    private AccountBalanceRepository accountBalanceRepository;

    @Autowired
    private AccountRelationshipRepository accountRelationshipRepository;

    @Override
    public Optional<AccountBalance> getAccountBalanceById(String id) {

        return accountBalanceRepository.findById(id);
    }

    @Override
    public Optional<AccountRelationship> getAccountRelationshipById(String id) {
        return accountRelationshipRepository.findById(id);
    }
}
