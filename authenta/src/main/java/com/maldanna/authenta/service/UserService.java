package com.maldanna.authenta.service;

import java.util.List;

import com.maldanna.authenta.model.Role;
import com.maldanna.authenta.model.User;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String userName,String roleName);
    User getUser(String userName);
    List<User> getusers();
}
