package com.mabay.ticketservice.repository.elasticsearch;

import com.mabay.ticketservice.entity.elasticsearch.TicketModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketElasticRepository extends ElasticsearchRepository<TicketModel, String> {

}
