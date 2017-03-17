package com.cape.configurations;

import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration{

    @Value( "${mongo.dbName}" )
    private String dbName;

    @Value( "${mongo.host}" )
    private String host;

    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new Mongo(host);
    }
}
