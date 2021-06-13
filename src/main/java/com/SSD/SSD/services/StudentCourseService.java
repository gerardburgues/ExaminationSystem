package com.SSD.SSD.services;

import com.SSD.SSD.model.Course;
import com.SSD.SSD.model.Student;
import com.SSD.SSD.model.StudentCourse;
import com.SSD.SSD.repos.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCourseService {

    private final StudentCourseRepository studentCourseRepository;

    @Autowired
    public StudentCourseService(StudentCourseRepository studentCourseRepository) {
        this.studentCourseRepository = studentCourseRepository;
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
