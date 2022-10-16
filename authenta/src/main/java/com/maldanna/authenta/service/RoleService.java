package com.maldanna.authenta.service;

import com.maldanna.authenta.model.Role;

public interface RoleService {

    public Role saveRole(Role role);
    Role getRole(String name);

 
}
