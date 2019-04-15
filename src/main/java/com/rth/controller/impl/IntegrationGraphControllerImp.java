package com.rth.controller.impl;

import com.rth.controller.IntegrationGraphController;
import com.rth.dao.IntegrationGraphDao;
import com.rth.model.IntegrationGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/graph")
public class IntegrationGraphControllerImp implements IntegrationGraphController {

    @Autowired
    private IntegrationGraphDao dao;
    @RequestMapping(method = RequestMethod.GET, value = "/{name}")
    @Override
    public IntegrationGraph integrationGraph(@PathVariable  String name) {
         IntegrationGraph graph = dao.findByName(name);
         graph =  new IntegrationGraph();
         graph.setName("MyGraph48081");
         return graph;
    }

    @Override
    public String add(IntegrationGraph graph) {
        if(graph == null){
            return null;
        }
        parse(graph);
        dao.save(graph);
        return null;
    }

    boolean parse(IntegrationGraph graph){
        //TODO  process the grap, assembly spring integration configuration
        return true;
    }

}
