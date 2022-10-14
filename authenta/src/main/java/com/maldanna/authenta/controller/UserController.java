package com.maldanna.authenta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maldanna.authenta.model.User;
import com.maldanna.authenta.service.UserService;



@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    UserService uService;
    
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return uService.getusers();

    }
}
