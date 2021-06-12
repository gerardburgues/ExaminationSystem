package com.SSD.SSD.services;

import com.SSD.SSD.model.MyUserDetails;
import com.SSD.SSD.model.Student;
import com.SSD.SSD.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsServices implements UserDetailsService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Student> student  = studentRepository.findStudentsByUserByUserId_Email(s);
        student.orElseThrow(() -> new UsernameNotFoundException("Not Found" + s));
        return student.map(MyUserDetails::new).get();

    }




}
