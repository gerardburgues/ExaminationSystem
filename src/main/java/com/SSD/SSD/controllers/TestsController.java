package com.SSD.SSD.controllers;

import com.SSD.SSD.model.*;
import com.SSD.SSD.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(path = "tests")
public class TestsController {

    private final TestsService testsService;
    private final QuestionService questionService;
    private final StudentTestService studentTestService;
    private final AnswerService answerService;
    private final UsersService usersService;
    private final StudentQuestionAnswerService studentQuestionAnswerService;

    @Autowired
    public TestsController(TestsService testsService, AnswerService answerService, QuestionService questionService,
                           QuestionTypeService questionTypeService, CourseService courseService, UsersService usersService,
                           StudentQuestionAnswerService studentQuestionAnswerService, StudentTestService studentTestService) {
        this.testsService = testsService;
        this.questionService = questionService;
        this.answerService = answerService;
        this.usersService = usersService;
        this.studentQuestionAnswerService = studentQuestionAnswerService;
        this.studentTestService = studentTestService;
    }
    @GetMapping(path = "/save")
    public void saveTest(){

//        MyUserDetails principal = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        Question question = questionService.findQuestionById(193);
//
//        Student student = usersService.findUserById(principal.getUserId()).getStudentsByUserId();
//
//        System.out.println(question.getQuestionId());
//        System.out.println(student.getStudentId());
//
//        StudentQuestionAnswer sqa = studentQuestionAnswerService.findByStudentAndQuestion(student, question).get();
//
//        System.out.println(sqa.getAnswerByAnswerId().getValue());
//
//
//        QuestionType questionType = questionTypeService.findQuestionTypeById(1);
//
//        Course currentCourse = courseService.findCourseById(1);
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
//        Question q1 = new Question();
//        q1.setQuestionTypeByQuestionTypeId(questionType);
//        q1.setQuestionText("Who do you prefer?");
//        q1.setAnswersByQuestionId(answersQ1);
//
//        Answer a21 = new Answer();
//        Answer a22 = new Answer();
//        Answer a23 = new Answer();
//
//        a21.setValue("Zupa");
//        a21.setIsCorrect(false);
//
//        a22.setValue("Cola");
//        a22.setIsCorrect(true);
//
//        a23.setValue("Obiad");
//        a23.setIsCorrect(false);
//
//        List<Answer> answersQ2 = new ArrayList<>();
//        answersQ2.add(a21);
//        answersQ2.add(a22);
//        answersQ2.add(a23);
//
//        Question q2 = new Question();
//        q2.setQuestionTypeByQuestionTypeId(questionType);
//        q2.setQuestionText("Na co masz ochotę?");
//        q2.setAnswersByQuestionId(answersQ2);
//
//        Answer a31 = new Answer();
//        Answer a32 = new Answer();
//        Answer a33 = new Answer();
//
//        a31.setValue("Lalka");
//        a31.setIsCorrect(true);
//
//        a32.setValue("Grzywka");
//        a32.setIsCorrect(false);
//
//        a33.setValue("Drewno");
//        a33.setIsCorrect(false);
//
//        List<Answer> answersQ3 = new ArrayList<>();
//        answersQ3.add(a31);
//        answersQ3.add(a32);
//        answersQ3.add(a33);
//
//        Question q3 = new Question();
//        q3.setQuestionTypeByQuestionTypeId(questionType);
//        q3.setQuestionText("Co lubisz?");
//        q3.setAnswersByQuestionId(answersQ3);
//
//        Tests t1 = new Tests();
//        t1.setTestName("Podstawy Programowania cz.1");
//        t1.setDurationMinutes(30);
//        t1.setStartDate(LocalDate.now());
//        t1.setStartTime(LocalTime.now());
//        t1.setCourseByCourseId(currentCourse);
//
//        q1.setTestByTestId(t1);
//        q2.setTestByTestId(t1);
//        q3.setTestByTestId(t1);
//
//        a12.setQuestionByQuestionId(q1);
//        a11.setQuestionByQuestionId(q1);
//
//        a21.setQuestionByQuestionId(q2);
//        a22.setQuestionByQuestionId(q2);
//        a23.setQuestionByQuestionId(q2);
//
//        a31.setQuestionByQuestionId(q3);
//        a32.setQuestionByQuestionId(q3);
//        a33.setQuestionByQuestionId(q3);
//
//        testsService.saveTest(t1);
//        questionService.saveQuestion(q1);
//        questionService.saveQuestion(q2);
//        questionService.saveQuestion(q3);
//        answerService.saveAnswer(a11);
//        answerService.saveAnswer(a12);
//        answerService.saveAnswer(a21);
//        answerService.saveAnswer(a22);
//        answerService.saveAnswer(a23);
//        answerService.saveAnswer(a31);
//        answerService.saveAnswer(a32);
//        answerService.saveAnswer(a33);
    }

    @GetMapping(path = "/{testId}/{questionId}")
    public ModelAndView handleAnswer(@PathVariable Integer questionId, @PathVariable Integer testId,
                                     @RequestParam(value="answer", required = false) Integer answer) {

        Tests test = testsService.findTestById(testId);

        MyUserDetails principal = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Student student = usersService.findUserById(principal.getUserId()).getStudentsByUserId();

        ArrayList<Question> questions = new ArrayList<>(test.getQuestionsByTestId());

        Question currentQuestion = questionService.findQuestionById(questionId);

        if (answer != null) {

            StudentQuestionAnswer studentQuestionAnswer = new StudentQuestionAnswer();

            studentQuestionAnswer.setStudentByStudentId(student);

            studentQuestionAnswer.setQuestionByQuestionId(currentQuestion);

            studentQuestionAnswer.setAnswerByAnswerId(answerService.findAnswerById(answer));

            studentQuestionAnswerService.saveStudentQuestionAnswer(studentQuestionAnswer);
        }

        int currentQuestionIndex = questions.indexOf(currentQuestion);

        if (currentQuestionIndex != questions.size() - 1) {

            return new ModelAndView("redirect:/tests/" + testId + "/"
                    + questions.get(currentQuestionIndex + 1).getQuestionId() + "/question");
        }
        else{

            StudentTest studentTest = new StudentTest();

            studentTest.setStudentByStudentId(student);
            studentTest.setTestByTestId(test);

            studentTest.setMark(evaluateTest(student,test));

            studentTestService.saveStudentTest(studentTest);

            return new ModelAndView("redirect:/course/" + test.getCourseByCourseId().getCourseId());
        }
    }

    @GetMapping(path = "/{testId}/{questionId}/question")
    public ModelAndView nextQuestion(@PathVariable Integer questionId, @PathVariable Integer testId) {

        ModelAndView mav = new ModelAndView();

        Tests test = testsService.findTestById(testId);

        ArrayList<Question> questions = new ArrayList<>(test.getQuestionsByTestId());

        Question currentQuestion = questionService.findQuestionById(questionId);

        int currentQuestionIndex = questions.indexOf(currentQuestion);

        if (currentQuestionIndex != questions.size() - 1) {

            mav.addObject("buttonLabel", "Next question");
        }
        else{

            mav.addObject("buttonLabel", "Finish test");
        }

        Tests currentTest = currentQuestion.getTestByTestId();

        mav.addObject("currentUrl","tests/" + testId + "/"
                + questions.get(currentQuestionIndex).getQuestionId());
        mav.addObject("currentQuestion", currentQuestion);
        mav.addObject("currentAnswers", currentQuestion.getAnswersByQuestionId());
        mav.addObject("currentTest", currentTest);
        mav.addObject("currentCourse", currentTest.getCourseByCourseId());

        mav.setViewName("test");

        return mav;
    }

    private double evaluateTest(Student student, Tests test){

        ArrayList<Question> testQuestions = new ArrayList<>(test.getQuestionsByTestId());

        int numberOfCorrectAnswers = 0;

        Optional<StudentQuestionAnswer> answer;

        for (Question question : testQuestions){

            answer = studentQuestionAnswerService.findByStudentAndQuestion(student, question);

            if (answer.isPresent() && answer.get().getAnswerByAnswerId().getIsCorrect()){

                numberOfCorrectAnswers++;
            }
        }

        return (double)numberOfCorrectAnswers / testQuestions.size() * 100;
    }
}
