package com.maldanna.authenta.service;

import java.util.List;

import com.maldanna.authenta.model.Role;
import com.maldanna.authenta.model.MyUser;

public interface UserService {
    MyUser saveUser(MyUser user);
    Role saveRole(Role role);
    void addRoleToUser(String userName,String roleName);
    MyUser getUser(String userName);
    List<MyUser> getusers();
}
