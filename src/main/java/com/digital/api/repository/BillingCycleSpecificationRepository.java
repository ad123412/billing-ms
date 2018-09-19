package com.digital.api.repository;

import com.digital.api.model.BillingCycleSpecificationRef;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingCycleSpecificationRepository extends ElasticsearchRepository<BillingCycleSpecificationRef, String> {
}
