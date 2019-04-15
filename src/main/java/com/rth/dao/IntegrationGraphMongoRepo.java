package com.rth.dao;

import com.rth.model.IntegrationGraph;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IntegrationGraphMongoRepo extends MongoRepository<IntegrationGraph, String> {
    IntegrationGraph findByName(String name);
}
