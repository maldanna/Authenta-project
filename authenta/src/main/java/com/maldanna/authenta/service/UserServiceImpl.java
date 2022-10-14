package com.maldanna.authenta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.maldanna.authenta.model.Role;
import com.maldanna.authenta.model.MyUser;
import com.maldanna.authenta.repository.RoleRepo;
import com.maldanna.authenta.repository.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService,UserDetailsService{

    @Autowired
    UserRepo uRepo;
    @Autowired
    RoleRepo roleRepo;

    @Override
    public MyUser saveUser(MyUser user) {
        log.info("save user");
        return uRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        MyUser user=uRepo.findByUsername(userName);
        Role role=roleRepo.findByName(roleName);
        user.getRoles().add(role); // due to @Transactional annotation it will save directly into database
        uRepo.save(user);
        
    }

    @Override
    public MyUser getUser(String userName) {
        return uRepo.findByUsername(userName);
    }

    @Override
    public List<MyUser> getusers() {
        return uRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       MyUser user=uRepo.findByUsername(username);

        return  null;
    }

    
}
