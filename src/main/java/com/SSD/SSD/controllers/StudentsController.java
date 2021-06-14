package com.SSD.SSD.controllers;

import com.SSD.SSD.model.StudentCourse;
import com.SSD.SSD.model.StudentTest;
import com.SSD.SSD.services.StudentCourseService;
import com.SSD.SSD.services.StudentService;
import com.SSD.SSD.services.StudentTestService;
import com.SSD.SSD.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "students")
public class StudentsController {

    private final StudentService studentService;
    private final StudentCourseService studentCourseService;
    private final StudentTestService studentTestService;
    private final UsersService usersService;

    @Autowired
    public StudentsController(StudentService studentService, StudentCourseService studentCourseService, StudentTestService studentTestService, UsersService usersService) {
        this.studentService = studentService;
        this.studentCourseService = studentCourseService;
        this.studentTestService = studentTestService;
        this.usersService = usersService;
    }


}
