package com.SSD.SSD.services;

import com.SSD.SSD.model.Student;
import com.SSD.SSD.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentServices {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServices(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Collection<Student> findAllStudents(){

        return studentRepository.findAll();
    }
}