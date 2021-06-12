package com.SSD.SSD.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class MyUserDetails implements UserDetails {

    private Integer Index_no;
    private String Email;
    private String Name;
    private String Password;

    private Long Pesel;
    private String Surname;

    public MyUserDetails(Student student){

        this.Index_no = student.getIndexNo();
        this.Email = student.getUserByUserId().getEmail();
        this.Name = student.getUserByUserId().getName();
        this.Pesel = student.getUserByUserId().getPesel();
        this.Surname = student.getUserByUserId().getSurname();
        this.Password = student.getUserByUserId().getPassword();

    }
    public MyUserDetails(){


    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return Password;
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
