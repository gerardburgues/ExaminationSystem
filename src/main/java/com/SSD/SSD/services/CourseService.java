package com.SSD.SSD.services;

import com.SSD.SSD.model.Course;
import com.SSD.SSD.repos.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Optional<Course> findCourseById(Integer id){

        return courseRepository.findById(id);
    }
}
