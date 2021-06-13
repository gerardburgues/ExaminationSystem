package com.SSD.SSD.controllers;

import com.SSD.SSD.model.*;
import com.SSD.SSD.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "tests")
public class TestsController {

    private final TestsService testsService;
    private final QuestionService questionService;
    private final QuestionTypeService questionTypeService;
    private final AnswerService answerService;
    private final CourseService courseService;
    private final UsersService usersService;

    @Autowired
    public TestsController(TestsService testsService, AnswerService answerService, QuestionService questionService,
                           QuestionTypeService questionTypeService, CourseService courseService, UsersService usersService) {
        this.testsService = testsService;
        this.questionService = questionService;
        this.answerService = answerService;
        this.questionTypeService = questionTypeService;
        this.courseService = courseService;
        this.usersService = usersService;
    }

//    @GetMapping(path = "/save")
//    public void saveTest(){
//
//        QuestionType questionType = questionTypeService.findQuestionTypeById(1).get();
//
//        Course course = courseService.findCourseById(1).get();
//
//        Answer a11 = new Answer();
//        Answer a12 = new Answer();
//
//        a11.setValue("Krowa");
//        a11.setIsCorrect(false);
//
//        a12.setValue("Kurczak");
//        a12.setIsCorrect(true);
//
//        List<Answer> answersQ1 = new ArrayList<>();
//        answersQ1.add(a11);
//        answersQ1.add(a12);
//
//        Answer a21 = new Answer();
//        Answer a22 = new Answer();
//
//        Question q1 = new Question();
//        q1.setQuestionTypeByQuestionTypeId(questionType);
//
//        q1.setAnswersByQuestionId(answersQ1);
//
//        Question q2 = new Question();
//
//        List<Question> questions = new ArrayList<>();
//        questions.add(q1);
//
//        Tests t1 = new Tests();
//        t1.setTestName("Podstawy Programowania cz.1");
//        t1.setDurationMinutes(30);
//        t1.setStartDate(LocalDate.now());
//        t1.setStartTime(LocalTime.now());
//        t1.setCourseByCourseId(course);
//
//        q1.setTestByTestId(t1);
//
//        a12.setQuestionByQuestionId(q1);
//        a11.setQuestionByQuestionId(q1);
//
//        testsService.saveTest(t1);
//        questionService.saveQuestion(q1);
//        answerService.saveAnswer(a11);
//        answerService.saveAnswer(a12);
//
//        usersService.deleteUser(usersService.findUserById(5).get());
//    }
}
