package com.SSD.SSD.controllers;

import com.SSD.SSD.model.Course;
import com.SSD.SSD.model.StudentCourse;
import com.SSD.SSD.services.CourseService;
import com.SSD.SSD.services.StudentCourseService;
import com.SSD.SSD.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "course")
public class CourseController {

    private final CourseService courseService;
    private final StudentCourseService studentCourseService;
    private final StudentService studentService;

    @Autowired
    public CourseController(CourseService courseService, StudentCourseService studentCourseService, StudentService studentService) {
        this.courseService = courseService;
        this.studentCourseService = studentCourseService;
        this.studentService = studentService;
    }

    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model){

        StudentCourse studentCourse = new StudentCourse();
        model.addAttribute("studentcourse", studentCourse);
        return "new_student";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") StudentCourse studentCourse) {
        // save employee to database
        studentCourseService.saveStudentCourse(studentCourse);
        return "redirect:/";
    }


    @GetMapping
    public String displayCourse (Model model){

        Course course = courseService.findCourseById(1).get();

        model.addAttribute("course", course);

        return "course";
    }
}
