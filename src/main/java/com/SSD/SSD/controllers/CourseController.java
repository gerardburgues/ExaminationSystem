package com.SSD.SSD.controllers;

import com.SSD.SSD.model.*;
import com.SSD.SSD.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping(path = "course")
public class CourseController {

    private final CourseService courseService;
    private final StudentService studentService;
    private final TestsService testsService;
    private final StudentCourseService studentCourseService;
    private final UsersService usersService;
    private final StudentTestService studentTestService;

    @Autowired
    public CourseController(CourseService courseService, StudentService studentService, TestsService testsService,
                            StudentCourseService studentCourseService, UsersService usersService, StudentTestService studentTestService) {
        this.courseService = courseService;
        this.studentService = studentService;
        this.testsService = testsService;
        this.studentCourseService = studentCourseService;
        this.usersService = usersService;
        this.studentTestService = studentTestService;
    }

    @GetMapping(path = "/{id}")
    public ModelAndView displayCourse(@PathVariable Integer id, HttpServletRequest request){

        ModelAndView mav = new ModelAndView("course");
        Course course = courseService.findCourseById(id);

        Collection<StudentCourse> studentCourses = course.getStudentCoursesByCourseId();
        ArrayList<Student> studentsEnrolled = new ArrayList<>();

        for(StudentCourse studentCourse : studentCourses){

            studentsEnrolled.add(studentCourse.getStudentByStudentId());
        }

        ArrayList<Tests> courseTests = new ArrayList<>(course.getTestsByCourseId());

        HashMap<Tests, String> testScoresMap = new HashMap<>();

        MyUserDetails principal = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Student student = usersService.findUserById(principal.getUserId()).getStudentsByUserId();

        Optional<StudentTest> studentTestOptional;

        for (Tests test : courseTests) {

            studentTestOptional = studentTestService.findByStudentAndTest(student,test);

            if (studentTestOptional.isPresent()) {

                testScoresMap.put(test, String.format("%.2f", studentTestOptional.get().getMark()) + "%");
            }
            else {

                testScoresMap.put(test, "no attempts yet");
            }
        }

        if(request != null){

            mav.addObject("errorMessage", request.getParameter("errorMessage"));
        }

        mav.addObject("testScoresMap", testScoresMap);
        mav.addObject("currentCourse", course);
        mav.addObject("studentsEnrolled", studentsEnrolled);

        return mav;
    }

    @GetMapping(path = "/professor/{id}")
    public ModelAndView displayProfessorCourse(@PathVariable Integer id,HttpServletRequest request){

        ModelAndView mav = new ModelAndView("courseProfessor");

        Course course = courseService.findCourseById(id);

        Collection<StudentCourse> studentCourses = course.getStudentCoursesByCourseId();
        ArrayList<Student> studentsEnrolled = new ArrayList<>();

        for(StudentCourse studentCourse : studentCourses){

            studentsEnrolled.add(studentCourse.getStudentByStudentId());
        }

        if(request != null){

            mav.addObject("errorMessage", request.getParameter("errorMessage"));
        }

        mav.addObject("currentCourse", course);
        mav.addObject("studentsEnrolled", studentsEnrolled);

        return mav;
    }

    @PostMapping(path = "/professor/{courseId}/addStudent")
    public ModelAndView addStudentToCourse(@RequestParam(value="indexNo", required = true) String indexNo,
                                           @PathVariable Integer courseId){

        ModelAndView mav = new ModelAndView("redirect:/course/professor/" + courseId);
        StudentCourse studentCourse = new StudentCourse();

        if(indexNo.matches("\\d+")){

            Student student = studentService.findByIndexNo(Integer.parseInt(indexNo));

            if(student != null){

                studentCourse.setCourseByCourseId(courseService.findCourseById(courseId));
                studentCourse.setStudentByStudentId(student);

                studentCourseService.saveStudentCourse(studentCourse);
            }
            else{

                mav.addObject("errorMessage", "No student with provided ID found");
            }
        }
        else{

            mav.addObject("errorMessage", "Incorrect Student ID value!");
        }

        return mav;
    }

    @GetMapping(path = "/{courseId}/deleteStudent/{studentId}")
    public ModelAndView deleteStudentFromCourse(@PathVariable Integer courseId, @PathVariable Integer studentId){

        ModelAndView mav = new ModelAndView("redirect:/course/professor/"+courseId);

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

    @GetMapping(path = "{courseId}/takeTest/{testId}")
    public ModelAndView displayTest(@PathVariable Integer courseId, @PathVariable Integer testId) {

        ModelAndView mav = new ModelAndView();

        Tests test = testsService.findTestById(testId);
        System.out.println(test.getTestName());
        MyUserDetails principal = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Student student = usersService.findUserById(principal.getUserId()).getStudentsByUserId();
        System.out.println(student.getUserByUserId().getEmail());
        Optional<StudentTest> studentTestOptional = studentTestService.findByStudentAndTest(student, test);

        if (studentTestOptional.isPresent()) {

            mav.addObject("errorMessage", "You have already completed this test!");
            mav.setViewName("redirect:/course/" + courseId);
        }
        else if(isTestClosed(test)){

            mav.addObject("errorMessage", "The test time frame is closed!");
            mav.setViewName("redirect:/course/" + courseId);
        }
        else {

            ArrayList<Question> questions = new ArrayList<>(test.getQuestionsByTestId());

            mav.setViewName("redirect:/tests/" + testId + "/" + questions.get(0).getQuestionId() + "/question");
        }

        return mav;
    }

    private boolean isTestClosed(Tests test){

        LocalDate dateStart = test.getStartDate();
        LocalTime timeStart = test.getStartTime();

        LocalDateTime startDateTime = LocalDateTime.of(dateStart, timeStart);
        LocalDateTime endDateTime = startDateTime.plusMinutes(test.getDurationMinutes());

        return LocalDateTime.now().isBefore(startDateTime) || LocalDateTime.now().isAfter(endDateTime);
    }
}
