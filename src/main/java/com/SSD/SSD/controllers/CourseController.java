package com.SSD.SSD.controllers;

import com.SSD.SSD.model.Course;
import com.SSD.SSD.model.Student;
import com.SSD.SSD.model.StudentCourse;
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
    public ModelAndView displayCourse(@PathVariable Integer id,@ModelAttribute("ss") Student student){

        ModelAndView mav = new ModelAndView("course");
        Course course = courseService.findCourseById(id).get();

        Collection<StudentCourse> studentCourses = course.getStudentCoursesByCourseId();
        ArrayList<Student> studentsEnrolled = new ArrayList<>();

        for(StudentCourse studentCourse : studentCourses){

            studentsEnrolled.add(studentCourse.getStudentByStudentId());
        }

        mav.addObject("currentcourse", course);
        mav.addObject("allStudents",studentService.findAllStudents());
        mav.addObject("studentsEnrolled", studentsEnrolled);

        return mav;
    }


    @PostMapping(path = "/addStudent")
    public ModelAndView addStudentToCourse(@RequestParam(value="indexNo", required = true)String indexNo,
                                           @RequestParam(value= "id", required = true) String id){

        ModelAndView mav = new ModelAndView("redirect:/currentcourse/"+id);
        StudentCourse studentCourse = new StudentCourse();
//SEARCH A REAL STUDENT BY ss

        studentCourse.setCourseByCourseId(courseService.findCourseById(Integer.parseInt(id)).get());
        studentCourse.setStudentByStudentId(studentService.findByIndexNo(Integer.parseInt(indexNo)));

        System.out.println(studentService.findByIndexNo(Integer.parseInt(indexNo)));
        studentCourseService.saveStudentCourse(studentCourse);

        return mav;
    }

    @GetMapping(path = "/{courseId}/deleteStudent/{studentId}")
    public ModelAndView deleteStudentFromCourse(@PathVariable Integer courseId, @PathVariable Integer studentId){

        ModelAndView mav = new ModelAndView("redirect:/currentcourse/"+courseId);

        StudentCourse studentCourse = studentCourseService.findStudentCourseByStudentAndCourse(
                studentService.findStudentById(studentId).get(), courseService.findCourseById(courseId).get());

        studentCourseService.deleteStudentCourse(studentCourse);

        return mav;
    }



}
