package com.maldanna.authenta.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Entity
@AllArgsConstructor
public class MyUser {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String roles;

    @ManyToMany(fetch = FetchType.EAGER) // to load role eargarly
    @JoinTable(name="User_Role",
        joinColumns = {@JoinColumn(name="User_Id")},
        inverseJoinColumns={@JoinColumn(name="Role_Id")}
    )
    private Set<Role> role;

}
