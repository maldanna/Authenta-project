package com.maldanna.authenta.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.maldanna.authenta.model.MyUser;

public class SecurityUserImpl implements UserDetails {

    private MyUser user;

    SecurityUserImpl(MyUser user){
        this.user=user;
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public String getPassword() {
        System.out.println("password is:"+user.getPassword());
        return user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       // return (Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new)).toList();
       return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    
}
