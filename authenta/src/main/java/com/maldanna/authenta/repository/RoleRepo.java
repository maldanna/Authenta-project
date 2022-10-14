package com.maldanna.authenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maldanna.authenta.model.Role;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
