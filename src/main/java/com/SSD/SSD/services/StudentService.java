package com.SSD.SSD.services;

import com.SSD.SSD.model.Student;
import com.SSD.SSD.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Collection<Student> findAllStudents(){

        return studentRepository.findAll();
    }

    public Student findStudentById(Integer id){

        return studentRepository.findById(id).get();
    }

    public Student findByIndexNo(Integer indexNo) {

        return studentRepository.findByIndexNo(indexNo);
    }
}
