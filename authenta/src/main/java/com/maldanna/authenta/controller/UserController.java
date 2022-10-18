package com.maldanna.authenta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maldanna.authenta.Utility.JwtRequest;
import com.maldanna.authenta.model.MyUser;
import com.maldanna.authenta.service.JwtToken;
import com.maldanna.authenta.service.UserServiceImpl;



@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserServiceImpl uService;

    @Autowired
    JwtToken jwtToken;

    @Autowired
	private AuthenticationManager authenticationManager;
    

    
    @GetMapping("/users")
    public List<MyUser> getAllUsers(){
        System.out.println("get all users method");
        return uService.getusers();
    }

    @PostMapping("/signup")
    public ResponseEntity<String>  saveUser(@RequestBody MyUser user){
        uService.saveUser(user);
        return new ResponseEntity<String>("You registered Successfully!! ",HttpStatus.OK);
    }

    
    @PostMapping("/login")
    public ResponseEntity<String>  loginUser(@RequestBody JwtRequest authenticationRequest) throws Exception{
        System.out.print("done");
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = uService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtToken.generateToken(userDetails);
        return new ResponseEntity<String>("You registered Successfully!! token: "+token,HttpStatus.OK);
    }


    private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (Exception e) {
            System.out.println("exception occurred in authenticate method: "+e.getMessage());
			throw new Exception("USER_DISABLED", e);
		} 
	}



    /* 
    @RequestMapping(value = "/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		final UserDetails userDetails = uService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtToken.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}*/




}
