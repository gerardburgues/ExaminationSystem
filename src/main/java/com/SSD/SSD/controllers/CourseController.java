package com.SSD.SSD.controllers;

import com.SSD.SSD.model.*;
import com.SSD.SSD.services.CourseService;
import com.SSD.SSD.services.StudentCourseService;
import com.SSD.SSD.services.StudentService;
import com.SSD.SSD.services.TestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping(path = "course")
public class CourseController {

    private final CourseService courseService;
    private final StudentService studentService;
    private final TestsService testsService;
    private final StudentCourseService studentCourseService;

    @Autowired
    public CourseController(CourseService courseService, StudentService studentService, TestsService testsService,
                            StudentCourseService studentCourseService) {
        this.courseService = courseService;
        this.studentService = studentService;
        this.testsService = testsService;
        this.studentCourseService = studentCourseService;
    }

    @GetMapping(path = "/{id}")
    public ModelAndView displayCourse(@PathVariable Integer id){

        ModelAndView mav = new ModelAndView("course");
        Course course = courseService.findCourseById(id).get();

        Collection<StudentCourse> studentCourses = course.getStudentCoursesByCourseId();
        ArrayList<Student> studentsEnrolled = new ArrayList<>();

        for(StudentCourse studentCourse : studentCourses){

            studentsEnrolled.add(studentCourse.getStudentByStudentId());
        }

        mav.addObject("course", course);
        mav.addObject("allStudents", studentService.findAllStudents());
        mav.addObject("studentsEnrolled", studentsEnrolled);

        return mav;
    }

    @GetMapping(path = "/{courseId}/addStudent/{studentId}")
    public ModelAndView addStudentToCourse(@PathVariable Integer courseId, @PathVariable Integer studentId){

        ModelAndView mav = new ModelAndView("redirect:/course/"+courseId);
        StudentCourse studentCourse = new StudentCourse();

        studentCourse.setCourseByCourseId(courseService.findCourseById(courseId).get());
        studentCourse.setStudentByStudentId(studentService.findStudentById(studentId).get());

        studentCourseService.saveStudentCourse(studentCourse);

        return mav;
    }

    @GetMapping(path = "/{courseId}/deleteStudent/{studentId}")
    public ModelAndView deleteStudentFromCourse(@PathVariable Integer courseId, @PathVariable Integer studentId){

        ModelAndView mav = new ModelAndView("redirect:/course/"+courseId);

        StudentCourse studentCourse = studentCourseService.findStudentCourseByStudentAndCourse(
                studentService.findStudentById(studentId).get(), courseService.findCourseById(courseId).get());

        studentCourseService.deleteStudentCourse(studentCourse);

        return mav;
    }

    @GetMapping(path = "/{courseId}/deleteTest/{testId}")
    public ModelAndView deleteTestFromCourse(@PathVariable Integer courseId, @PathVariable Integer testId){

        ModelAndView mav = new ModelAndView("redirect:/course/"+courseId);

        testsService.deleteTest(testsService.findTestById(testId).get());

        return mav;
    }

    @GetMapping(path = "/{courseId}/takeTest/{testId}")
    public ModelAndView displayTest(@PathVariable Integer courseId, @PathVariable Integer testId){

        ModelAndView mav = new ModelAndView("test");

        mav.addObject("course", courseService.findCourseById(courseId).get());
        mav.addObject("studentsEnrolled", testsService.findTestById(testId).get());
    }
}
