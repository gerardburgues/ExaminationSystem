package com.SSD.SSD.controllers;

import com.SSD.SSD.model.*;
import com.SSD.SSD.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final UsersService usersService;

    @Autowired
    public CourseController(CourseService courseService, StudentService studentService, TestsService testsService,
                            StudentCourseService studentCourseService, UsersService usersService) {
        this.courseService = courseService;
        this.studentService = studentService;
        this.testsService = testsService;
        this.studentCourseService = studentCourseService;
        this.usersService = usersService;
    }

    @GetMapping(path = "/{id}")
    public ModelAndView displayCourse(@PathVariable Integer id){

        ModelAndView mav = new ModelAndView("course");
        Course course = courseService.findCourseById(id);

        Collection<StudentCourse> studentCourses = course.getStudentCoursesByCourseId();
        ArrayList<Student> studentsEnrolled = new ArrayList<>();

        for(StudentCourse studentCourse : studentCourses){

            studentsEnrolled.add(studentCourse.getStudentByStudentId());
        }

        mav.addObject("currentCourse", course);
        mav.addObject("studentsEnrolled", studentsEnrolled);

        return mav;
    }

    @PostMapping(path = "{courseId}/addStudent")
    public ModelAndView addStudentToCourse(@RequestParam(value="indexNo", required = true) String indexNo,
                                           @PathVariable Integer courseId){

        ModelAndView mav = new ModelAndView("redirect:/course/" + courseId);
        StudentCourse studentCourse = new StudentCourse();

        studentCourse.setCourseByCourseId(courseService.findCourseById(courseId));
        studentCourse.setStudentByStudentId(studentService.findByIndexNo(Integer.parseInt(indexNo)));

        studentCourseService.saveStudentCourse(studentCourse);

        return mav;
    }

    @GetMapping(path = "/{courseId}/deleteStudent/{studentId}")
    public ModelAndView deleteStudentFromCourse(@PathVariable Integer courseId, @PathVariable Integer studentId){

        ModelAndView mav = new ModelAndView("redirect:/currentCourse/"+courseId);

        StudentCourse studentCourse = studentCourseService.findStudentCourseByStudentAndCourse(
                studentService.findStudentById(studentId), courseService.findCourseById(courseId));

        studentCourseService.deleteStudentCourse(studentCourse);

        return mav;
    }

    @GetMapping(path = "/{courseId}/deleteTest/{testId}")
    public ModelAndView deleteTestFromCourse(@PathVariable Integer courseId, @PathVariable Integer testId){

        ModelAndView mav = new ModelAndView("redirect:/currentCourse/"+courseId);

        testsService.deleteTest(testsService.findTestById(testId));

        return mav;
    }

    @GetMapping(path = "/takeTest/{testId}")
    public ModelAndView displayTest(@PathVariable Integer testId){

        Tests test = testsService.findTestById(testId);

        ArrayList<Question> questions = new ArrayList<>(test.getQuestionsByTestId());

        ModelAndView mav = new ModelAndView("redirect:/tests/" + testId + "/" + questions.get(0).getQuestionId());

        return mav;
    }
}
