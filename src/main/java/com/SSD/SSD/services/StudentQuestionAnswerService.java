package com.SSD.SSD.services;

import com.SSD.SSD.model.Question;
import com.SSD.SSD.model.Student;
import com.SSD.SSD.model.StudentQuestionAnswer;
import com.SSD.SSD.repos.StudentQuestionAnswerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentQuestionAnswerService {

    private final StudentQuestionAnswerRepository studentQuestionAnswerRepository;

    public StudentQuestionAnswerService(StudentQuestionAnswerRepository studentQuestionAnswerRepository) {
        this.studentQuestionAnswerRepository = studentQuestionAnswerRepository;
    }

    public void saveStudentQuestionAnswer(StudentQuestionAnswer studentQuestionAnswer){

        studentQuestionAnswerRepository.save(studentQuestionAnswer);
    }

    public Optional<StudentQuestionAnswer> findByStudentAndQuestion(Student student, Question question){

        return studentQuestionAnswerRepository.findByStudentByStudentIdAndQuestionByQuestionId(student, question);
    }
}
