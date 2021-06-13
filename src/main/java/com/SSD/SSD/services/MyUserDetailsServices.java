package com.SSD.SSD.services;

import com.SSD.SSD.model.MyUserDetails;

import com.SSD.SSD.model.Users;
import com.SSD.SSD.repos.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsServices implements UserDetailsService {

    @Autowired
    UsersRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Users> user  = userRepository.findUsersByEmail(s);
        user.orElseThrow(() -> new UsernameNotFoundException("Not FOund" + s));
        System.out.println(s);
        return user.map(MyUserDetails::new).get();

    }






}
