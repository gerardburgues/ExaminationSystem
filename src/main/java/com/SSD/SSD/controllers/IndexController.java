package com.SSD.SSD.controllers;

import com.SSD.SSD.model.*;
import com.SSD.SSD.services.*;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping(path = "index")
public class IndexController {

    private final StudentService studentService;
    private final StudentCourseService studentCourseService;
    private final StudentTestService studentTestService;
    private final UsersService usersService;
    private final CourseService courseService;

    @Autowired
    public IndexController(StudentService studentService, StudentCourseService studentCourseService,
                              StudentTestService studentTestService, UsersService usersService, CourseService courseService) {
        this.studentService = studentService;
        this.studentCourseService = studentCourseService;
        this.studentTestService = studentTestService;
        this.usersService = usersService;
        this.courseService = courseService;
    }

    @GetMapping(path="/role")
    public ModelAndView chooseRoleViewPage(HttpServletRequest request){

        ModelAndView mav = new ModelAndView("StudentOrProfessor");

        MyUserDetails principal = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users currentUser = usersService.findUserById(principal.getUserId());

        System.out.println(currentUser.getEmail());

        if(request != null){

            mav.addObject("errorMessage", request.getParameter("errorMessage"));
        }

        return mav;
    }

    @GetMapping(path="/start")
    public ModelAndView studentIndex(HttpServletRequest request){

        ModelAndView mav = new ModelAndView();

        MyUserDetails principal = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users currentUser = usersService.findUserById(principal.getUserId());

        if(currentUser.getStudentsByUserId() != null){

            ArrayList<StudentCourse> studentCourses  = new ArrayList<>(currentUser.getStudentsByUserId().getStudentCoursesByStudentId());

            ArrayList<Course> coursesList = new ArrayList<>();

            for (StudentCourse studentCourse : studentCourses) {

                coursesList.add(studentCourse.getCourseByCourseId());

            }

            mav.addObject("coursesList", coursesList);
            mav.setViewName("index");
        }
        else{

            mav.addObject("errorMessage", "You do not have permission to access this resource");
            mav.setViewName("redirect:/index/role");
        }

        return mav;

    }

    @GetMapping(path="/professor/start")
    public ModelAndView professorIndex(){

        ModelAndView mav = new ModelAndView("indexProfessor");

        MyUserDetails principal = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users currentUser = usersService.findUserById(principal.getUserId());

        if(currentUser.getProfessorsByUserId() != null){
            Collection<Course> coursesList = currentUser.getProfessorsByUserId().getCoursesByProfessorId();

            mav.addObject("coursesList",coursesList);

            mav.setViewName("indexProfessor");
        }
        else{

            mav.addObject("errorMessage", "You do not have permission to access this resource");
            mav.setViewName("redirect:/index/role");
        }

        return mav;

    }

}
