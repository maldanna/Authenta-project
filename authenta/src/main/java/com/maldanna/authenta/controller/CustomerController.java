package com.maldanna.authenta.controller;

import java.net.http.HttpHeaders;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.maldanna.authenta.model.CustomerData;
import com.maldanna.authenta.service.RambusHandler;

@RestController("/authenta")
public class CustomerController {

    @Autowired
    RambusHandler rHandler;

    @PostMapping("/nonce")
    public ResponseEntity<String> getNonce(@RequestBody @Valid CustomerData custData){  
        String response=null;
        return null;
        
       // return new ResponseEntity<String>("Custom header set", HttpStatus.OK);
    }

    public static void name() {

    }
    
}
