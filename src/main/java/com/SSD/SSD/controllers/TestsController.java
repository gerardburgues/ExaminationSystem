package com.SSD.SSD.controllers;

import com.SSD.SSD.model.*;
import com.SSD.SSD.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @GetMapping(path = "/save")
    public void saveTest(){

        QuestionType questionType = questionTypeService.findQuestionTypeById(1);

        Course currentCourse = courseService.findCourseById(1);

        Answer a11 = new Answer();
        Answer a12 = new Answer();

        a11.setValue("Krowa");
        a11.setIsCorrect(false);

        a12.setValue("Kurczak");
        a12.setIsCorrect(true);

        List<Answer> answersQ1 = new ArrayList<>();
        answersQ1.add(a11);
        answersQ1.add(a12);

        Question q1 = new Question();
        q1.setQuestionTypeByQuestionTypeId(questionType);
        q1.setQuestionText("Who do you prefer?");
        q1.setAnswersByQuestionId(answersQ1);

        Answer a21 = new Answer();
        Answer a22 = new Answer();
        Answer a23 = new Answer();

        a21.setValue("Zupa");
        a21.setIsCorrect(false);

        a22.setValue("Cola");
        a22.setIsCorrect(true);

        a23.setValue("Obiad");
        a23.setIsCorrect(false);

        List<Answer> answersQ2 = new ArrayList<>();
        answersQ2.add(a21);
        answersQ2.add(a22);
        answersQ2.add(a23);

        Question q2 = new Question();
        q2.setQuestionTypeByQuestionTypeId(questionType);
        q2.setQuestionText("Na co masz ochotę?");
        q2.setAnswersByQuestionId(answersQ2);

        Tests t1 = new Tests();
        t1.setTestName("Podstawy Programowania cz.1");
        t1.setDurationMinutes(30);
        t1.setStartDate(LocalDate.now());
        t1.setStartTime(LocalTime.now());
        t1.setCourseByCourseId(currentCourse);

        q1.setTestByTestId(t1);
        q2.setTestByTestId(t1);

        a12.setQuestionByQuestionId(q1);
        a11.setQuestionByQuestionId(q1);

        a21.setQuestionByQuestionId(q2);
        a22.setQuestionByQuestionId(q2);
        a23.setQuestionByQuestionId(q2);

        testsService.saveTest(t1);
        questionService.saveQuestion(q1);
        questionService.saveQuestion(q2);
        answerService.saveAnswer(a11);
        answerService.saveAnswer(a12);
        answerService.saveAnswer(a21);
        answerService.saveAnswer(a22);
        answerService.saveAnswer(a23);
    }

    @GetMapping(path = "/{testId}/{questionId}")
    public ModelAndView nextQuestion(@PathVariable Integer questionId, @PathVariable Integer testId){

        ModelAndView mav = new ModelAndView();

        Tests test = testsService.findTestById(testId);

        ArrayList<Question> questions = new ArrayList<>(test.getQuestionsByTestId());

        Question currentQuestion = questionService.findQuestionById(questionId);

        int currentQuestionIndex = questions.indexOf(currentQuestion);

        if(currentQuestionIndex < questions.size()){

            mav.addObject("nextStepUrl", "tests/" + testId + "/"
                    + questions.get(currentQuestionIndex + 1).getQuestionId());
        }
        else{

            mav.addObject("nextStepUrl", "course/" + test.getCourseByCourseId().getCourseId());
        }

        Tests currentTest = currentQuestion.getTestByTestId();

        mav.addObject("currentQuestion", currentQuestion);
        mav.addObject("currentTest", currentTest);
        mav.addObject("currentCourse", currentTest.getCourseByCourseId());

        mav.setViewName("test");

        return mav;
    }
}
