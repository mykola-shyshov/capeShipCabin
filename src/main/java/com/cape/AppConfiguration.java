package com.cape;

import com.cape.utils.version.VersionRequestMappingHandler;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableAutoConfiguration()
public class AppConfiguration {

    @Value( "${swaggerEnabled}" )
    private boolean swaggerEnabled;

    @Bean
    public VersionRequestMappingHandler provideVersionMapper() {
        VersionRequestMappingHandler handler = new VersionRequestMappingHandler();
        handler.setOrder( 0 );
        return handler;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule( new JodaModule() )
              .registerModule( new Jdk8Module() )
              .registerModule( new JavaTimeModule() );
        mapper.configure( SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false );
        mapper.setSerializationInclusion( JsonInclude.Include.NON_NULL );
        return mapper;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * Swagger's settings
     */
    @Bean
    public Docket swaggerApi() {
        return new Docket( DocumentationType.SWAGGER_2 ).enable( swaggerEnabled );
    }

//    @Override
//    protected String getDatabaseName() {
//        return "e-store";
//    }

//    @Override
//    public Mongo mongo() throws Exception {
//        return new Mongo();
//    }

//    @Override
//    protected String getMappingBasePackage() {
//        return "com.oreilly.springdata.mongodb";
//    }
}
