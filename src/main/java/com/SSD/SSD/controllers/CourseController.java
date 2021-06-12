package com.SSD.SSD.controllers;

import com.SSD.SSD.model.Course;
import com.SSD.SSD.services.CourseService;
import com.SSD.SSD.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "course")
public class CourseController {

    private final CourseService courseService;
    private final StudentService studentService;

    @Autowired
    public CourseController(CourseService courseService, StudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @GetMapping
    public String displayCourse (Model model){

        Course course = courseService.findCourseById(1).get();

        model.addAttribute("course", course);

        return "course";
    }
}
