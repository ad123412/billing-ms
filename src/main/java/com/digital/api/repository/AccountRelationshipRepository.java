package com.digital.api.repository;

import com.digital.api.model.AccountRelationship;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRelationshipRepository extends ElasticsearchRepository<AccountRelationship, String> {
}
