package com.SSD.SSD.services;

import com.SSD.SSD.model.Course;
import com.SSD.SSD.model.Student;
import com.SSD.SSD.model.StudentCourse;
import com.SSD.SSD.repos.StudentCourseRepository;
import com.SSD.SSD.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseService {

    private final StudentCourseRepository studentCourseRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public StudentCourseService(StudentCourseRepository studentCourseRepository, StudentRepository studentRepository) {
        this.studentCourseRepository = studentCourseRepository;
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void saveStudentCourse(StudentCourse studentCourse){

        studentCourseRepository.save(studentCourse);
    }

    public StudentCourse findStudentCourseByStudentAndCourse(Student student, Course course){

        return studentCourseRepository.findByStudentByStudentIdAndCourseByCourseId(student, course);
    }

    public void deleteStudentCourse(StudentCourse studentCourse){

        studentCourseRepository.delete(studentCourse);
    }
}
