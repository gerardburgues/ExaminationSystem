package com.SSD.SSD.services;

import com.SSD.SSD.model.MyUserDetails;

import com.SSD.SSD.model.Student;
import com.SSD.SSD.model.Users;
import com.SSD.SSD.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsServices implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    StudentServices studentServices;
    @Autowired
    ProfileService profileService;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Users> user  = userRepository.findUsersByEmail(s);
        if(profileService.getUserById(1).getStudentsByUserId() == null){
            System.out.println("ERROR");
            user.orElseThrow(() -> new UsernameNotFoundException("Not correct"+ s));
        }

        return user.map(MyUserDetails::new).get();



    }






}
