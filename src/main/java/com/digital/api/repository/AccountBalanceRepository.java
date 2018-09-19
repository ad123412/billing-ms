package com.digital.api.repository;

import com.digital.api.model.AccountBalance;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountBalanceRepository extends ElasticsearchRepository<AccountBalance, String> {
}
