package com.digital.api.repository;

import com.digital.api.model.BillStructure;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillStructureRepository extends ElasticsearchRepository<BillStructure, String> {
}
