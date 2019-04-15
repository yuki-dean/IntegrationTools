package com.rth.controller;

import com.rth.model.IntegrationGraph;
import org.springframework.web.bind.annotation.RequestBody;

public interface  IntegrationGraphController {
    /**
     * Fetch the graph data from repository, and return as graph object
     * @return
     */
    IntegrationGraph integrationGraph(String name);

    /**
     * Add a new graph in which name should be unique
     * ServiceException (HTTP 503) for unknown issues.
     * DataInvalidateException(HTTP 409)if an associated name is duplicated.
     * @param graph
     * @return
     */
    String add(@RequestBody IntegrationGraph graph);
}
