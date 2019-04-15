package com.rth.model;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import java.io.Serializable;
import java.util.List;

@Data
public class IntegrationGraph implements Serializable {
    @Indexed( unique = true)
    private String name;
    private List<Link> links;
    private List<Endpoint> endpoints;
}
