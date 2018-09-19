package com.digital.api.repository;

import com.digital.api.model.BillFormatRef;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillFormatRepository extends ElasticsearchRepository<BillFormatRef, String> {
}
