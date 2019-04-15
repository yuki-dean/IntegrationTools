package com.rth;


import com.mongodb.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableMongoAuditing
public class Config  extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.username}")
    private String username;

    @Value("${spring.data.mongodb.password}")
    private String password;

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private int port;

    @Value("${spring.data.mongodb.connectTimeout}")
    private int connectTimeout;

    @Value("${spring.data.mongodb.socketTimeout}")
    private int socketTimeout;

    @Value("${spring.data.mongodb.maxWaitTime}")
    private int maxWaitTime;

    @Value("${spring.data.mongodb.socketKeepAlive}")
    private boolean socketKeepAlive;

    private MongoClient client;

    @Override
    protected String getDatabaseName() {
        return database;
    }

    public Mongo mongo() throws UnknownHostException {
        return mongoClient();
    }

    @Override
    public @Bean
    MongoDbFactory mongoDbFactory() {
        return new SimpleMongoDbFactory(mongoClient(), getDatabaseName());
    }

    @Override
    public @Bean
    MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }

    @Override
    public MongoClient mongoClient() {
        try {
            return new MongoClient(getServerAddress(), getMongoCredential(), getMongoClientOptions());
        }catch (UnknownHostException e){
            e.printStackTrace();
        }
        return null;
    }

    /*
    private MongoClient getClient() throws UnknownHostException {
        if (client != null)
            return client;
        client = new MongoClient(getServerAddress(), getMongoCredentials(), getMongoClientOptions());
        return client;
    }
    */

    private ServerAddress getServerAddress() throws UnknownHostException {
        return new ServerAddress(host, port);
    }

    private MongoCredential getMongoCredential() {
        return MongoCredential.createCredential(username, getDatabaseName(), password.toCharArray());
    }

    private MongoClientOptions getMongoClientOptions() {
        return MongoClientOptions.builder().connectTimeout(connectTimeout).socketTimeout(socketTimeout)
                .maxWaitTime(maxWaitTime).socketKeepAlive(socketKeepAlive).build();
    }
}
