package com.digital.api.service;

import com.digital.api.model.AccountBalance;
import com.digital.api.model.AccountRelationship;
import com.digital.api.model.BillStructure;

import java.util.Optional;

public interface AccountBalanceService {

    public Optional<AccountBalance> getAccountBalanceById(String id);

    public Optional<AccountRelationship> getAccountRelationshipById(String id);
}
