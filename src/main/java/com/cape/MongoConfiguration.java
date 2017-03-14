package com.cape;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration{

    @Override
    protected String getDatabaseName() {
        return "hold";
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new Mongo("localhost");
    }
}
