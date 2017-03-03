package com.cape.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/v{er}" )
public class TestController {

    @GetMapping( "/test" )
    public String test() {
        return "OK";
    }
}
