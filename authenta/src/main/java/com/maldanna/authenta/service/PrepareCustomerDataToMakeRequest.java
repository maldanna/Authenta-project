package com.maldanna.authenta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maldanna.authenta.model.CustomerData;

@Service
public class PrepareCustomerDataToMakeRequest {
   
    @Autowired
    JwtToken gToken;

    public String getToken(CustomerData custData){
        custData.setCommands("command1,command2,command3");
        String token=gToken.generateToken(custData);
        return token;

    }

}
