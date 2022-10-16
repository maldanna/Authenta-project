package com.maldanna.authenta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("signup")
    public ResponseEntity<String>  saveUser(@RequestBody MyUser user){
        uService.saveUser(user);
        return new ResponseEntity<String>("You registered Successfully!! ",HttpStatus.OK);
    }

    
    @PostMapping("Login")
    public ResponseEntity<String>  loginUserr(@RequestBody MyUser user){
        //uService.findByName()
        return new ResponseEntity<String>("You registered Successfully!! ",HttpStatus.OK);
    }

    @PostMapping("/test11")
    public String test(@RequestBody() String name){
        return "test 432 432 432";
    }

}
