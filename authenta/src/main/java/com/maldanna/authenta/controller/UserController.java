package com.maldanna.authenta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maldanna.authenta.model.MyUser;
import com.maldanna.authenta.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService uService;
    
    @GetMapping("/users")
    public List<MyUser> getAllUsers(){
        return uService.getusers();

    }
}
