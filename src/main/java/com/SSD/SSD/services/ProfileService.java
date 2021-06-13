package com.SSD.SSD.services;

import com.SSD.SSD.model.Student;

import com.SSD.SSD.model.Users;
import com.SSD.SSD.repos.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ProfileService {

    void saveUser(Users user);
    Users getUserById(Integer id);
    Users getUserByEmail(String email);
}
