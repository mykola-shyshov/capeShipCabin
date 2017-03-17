package com.cape.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


// https://habrahabr.ru/post/245415/, http://www.baeldung.com/securing-a-restful-web-service-with-spring-security
// http://www.baeldung.com/spring-security-basic-authentication
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value( "${captain.login}" )
    private String captainName;

    @Value( "${captain.password}" )
    private String captainPassword;

    @Autowired
    public void configureGlobal( AuthenticationManagerBuilder auth ) throws Exception {
        auth.inMemoryAuthentication()
            .withUser( captainName )
            .password( captainPassword )
            .authorities( "CAPTAIN" );
    }

    @Override
    protected void configure( HttpSecurity http ) throws Exception {
        http.authorizeRequests()
            .antMatchers( "/v1/goods/", "/v1/orders/" ).permitAll()
            .anyRequest().authenticated()
            .and()
            .httpBasic();
    }
}