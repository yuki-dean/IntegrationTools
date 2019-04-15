package com.rth.dao;

import com.rth.model.IntegrationGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IntegrationGraphDao {
    @Autowired
    private IntegrationGraphMongoRepo repo;

    public IntegrationGraph findByName(String name ){
        return repo.findByName(name);
    }

    public void save(IntegrationGraph graph){
        repo.save(graph);
    }
}
