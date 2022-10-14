package com.maldanna.authenta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maldanna.authenta.model.Role;
import com.maldanna.authenta.model.User;
import com.maldanna.authenta.repository.RoleRepo;
import com.maldanna.authenta.repository.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo uRepo;
    @Autowired
    RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        log.info("save user");
        return uRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user=uRepo.findByUsername(userName);
        Role role=roleRepo.findByName(roleName);
        user.getRoles().add(role); // due to @Transactional annotation it will save directly into database
        uRepo.save(user);
        
    }

    @Override
    public User getUser(String userName) {
        return uRepo.findByUsername(userName);
    }

    @Override
    public List<User> getusers() {
        return uRepo.findAll();
    }

    
}
