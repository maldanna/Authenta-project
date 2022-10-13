package com.maldanna.authenta.service;

import java.net.http.HttpResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.maldanna.authenta.model.CustomerData;

@Service
public class RambusHandler {

    public String getNonce(CustomerData custData){

        HttpResponse httpResponse=null;
        String response = httpResponse.body().toString();
        return response;

    }
    
}
