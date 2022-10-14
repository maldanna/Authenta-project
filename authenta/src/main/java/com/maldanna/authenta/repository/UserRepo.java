package com.maldanna.authenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maldanna.authenta.model.User;

public interface UserRepo extends JpaRepository<User,Long>{

        User findByUsername(String username);

}
