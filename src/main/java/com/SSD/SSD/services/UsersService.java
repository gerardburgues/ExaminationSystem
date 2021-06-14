package com.SSD.SSD.services;

import com.SSD.SSD.model.Users;
import com.SSD.SSD.repos.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users findUserById(Integer id){

        return usersRepository.findById(id).get();
    }
    public Users findUserByEmail(String email){

        return usersRepository.findUsersByEmail(email).get();
    }

    public void saveUser(Users user){
        this.usersRepository.save(user);
    }
}
