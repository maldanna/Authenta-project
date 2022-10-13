package com.maldanna.authenta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maldanna.authenta.model.CustomerData;

@Service
public class PrepareCustomerDataToMakeRequest {
   
    @Autowired
    GenerateToken gToken;
    public String prepareDataAndMakeRequest(CustomerData custData){

        String token=gToken.generateToken(null);
        return token;

    }

}
