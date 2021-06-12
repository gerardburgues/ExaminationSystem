package com.SSD.SSD.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class MyUserDetails implements UserDetails {

    private String email;
    private String name;
    private String password;
    private Long pesel;
    private String surname;

    public MyUserDetails(Users user){

        this.email=user.getEmail();
        this.name=user.getName();
        this.password=user.getPassword();
        this.pesel= user.getPesel();
        this.surname=user.getSurname();

    }
    public MyUserDetails(){


    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
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
