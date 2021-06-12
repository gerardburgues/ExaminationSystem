package com.SSD.SSD.services;

import com.SSD.SSD.model.Student;

import com.SSD.SSD.model.Users;
import com.SSD.SSD.repos.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private  ProfileRepository profileRepository;


    @Override
    public void saveUser(Users user){
        this.profileRepository.save(user);
    }


    @Override
    public Users getUserById(Integer id){
        Optional<Users> optional = profileRepository.findById(id);
        Users user  = null;
        if(optional.isPresent()){  user = optional.get();}
        else{
            throw  new RuntimeException("Student not found" + id);
        }
        return user;

    }
}
