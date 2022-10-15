package com.maldanna.authenta.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.maldanna.authenta.model.CustomerData;
import com.maldanna.authenta.service.PrepareCustomerDataToMakeRequest;
import com.maldanna.authenta.service.RambusHandler;

@RestController
@RequestMapping("/authenta")
public class CustomerController {

    @Autowired
    RambusHandler rHandler;

    @Autowired
    PrepareCustomerDataToMakeRequest pCustRrequest;


    
    @GetMapping("/nonce")
    public ResponseEntity<String> getNonce(){  
        CustomerData custData=new CustomerData();
        custData.setCommands("maldanna1,maldanna2");
        custData.setMPN("ABC123");
        custData.setManufacturer("Micron");

        System.out.println("welcome to nonce");
        return new ResponseEntity<String>(pCustRrequest.getToken(custData), HttpStatus.OK);

    }


   /*  @PostMapping("/nonce")
    public ResponseEntity<String> getNonce(@RequestBody @Valid CustomerData custData){  

        System.out.println("welcome to nonce");
        return new ResponseEntity<String>(pCustRrequest.getToken(custData), HttpStatus.OK);

    }*/


    @GetMapping("/home")
    public String name() {
        return "home page";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "access denied";
    }


    
}
