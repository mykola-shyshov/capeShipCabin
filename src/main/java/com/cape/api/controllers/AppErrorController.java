package com.cape.api.controllers;

import com.cape.utils.errors.ApiException;
import com.cape.utils.errors.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping( "" )
public class AppErrorController implements ErrorController {
    private static Logger logger = LoggerFactory.getLogger( AppErrorController.class );
    @Override
    public String getErrorPath() {
        return "/error";
    }
    @RequestMapping( "/error" )
    public ResponseEntity error( HttpServletRequest request, HttpServletResponse response ) {
        logger.warn( "App error: {}", HttpStatus.valueOf( response.getStatus() ).getReasonPhrase() );
        return ResponseEntity.status(
              HttpStatus.valueOf( response.getStatus() )
        ).body(
              new ErrorResponse(
                     new ApiException(
                           HttpStatus.valueOf( response.getStatus() ),
                           HttpStatus.valueOf( response.getStatus() ).getReasonPhrase()
                     )
              )
        );
    }
}