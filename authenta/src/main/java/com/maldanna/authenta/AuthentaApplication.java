package com.maldanna.authenta;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.maldanna.authenta.model.MyUser;
import com.maldanna.authenta.model.Role;
import com.maldanna.authenta.repository.UserRepo;
import com.maldanna.authenta.service.UserServiceImpl;

@SpringBootApplication
public class AuthentaApplication {

	@Autowired
	PasswordEncoder pencode;
	public static void main(String[] args) {
		SpringApplication.run(AuthentaApplication.class, args);
		System.out.println("Hello world");
	}
	
	@Bean
	CommandLineRunner commandLineRunner(UserServiceImpl uService){
		return args -> {
			MyUser user1=new MyUser();
			user1.setUsername("maldanna");
			user1.setPassword(pencode.encode("maldanna"));
			user1.setRoles("ROLE_USER");
			uService.saveUser(user1);
		};
	}
}




