package com.maldanna.authenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maldanna.authenta.model.MyUser;

public interface UserRepo extends JpaRepository<MyUser,Long>{

        MyUser findByUsername(String username);

}
