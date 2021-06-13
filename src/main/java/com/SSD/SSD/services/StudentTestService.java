package com.SSD.SSD.services;

import com.SSD.SSD.model.StudentTest;
import com.SSD.SSD.repos.StudentTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentTestService {

    private final StudentTestRepository studentTestRepository;

    @Autowired
    public StudentTestService(StudentTestRepository studentTestRepository) {
        this.studentTestRepository = studentTestRepository;
    }

    public void saveStudentTest(StudentTest studentTest){

        studentTestRepository.save(studentTest);
    }
}
