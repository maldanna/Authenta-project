package com.maldanna.authenta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maldanna.authenta.model.Role;
import com.maldanna.authenta.repository.RoleRepo;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepo rRepo;

    @Override
    public Role getRole(String name) {
        return rRepo.findByName(name);
    }

    @Override
    public Role saveRole(Role role) {
        return rRepo.save(role);
    }
    
}
