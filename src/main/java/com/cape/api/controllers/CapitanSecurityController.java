package com.cape.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/captain/auth" )
public class CapitanSecurityController {

    @GetMapping( "/login" )
    public void login() {
        System.out.print( "loggin" );
    }
}
