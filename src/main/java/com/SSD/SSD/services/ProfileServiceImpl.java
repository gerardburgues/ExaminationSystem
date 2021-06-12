package com.SSD.SSD.services;

import com.SSD.SSD.model.Student;

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
    public void saveStudent(Student student){
        this.profileRepository.save(student);
    }


    @Override
    public Student getStudentById(Integer id){
        Optional<Student> optional = profileRepository.findById(id);
        Student student  = null;
        if(optional.isPresent()){  student = optional.get();}
        else{
            throw  new RuntimeException("Student not found" + id);
        }
        return student;

    }
}
