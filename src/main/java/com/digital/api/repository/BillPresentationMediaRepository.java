package com.digital.api.repository;

import com.digital.api.model.BillPresentationMediaRef;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillPresentationMediaRepository extends ElasticsearchRepository<BillPresentationMediaRef, String> {
}
