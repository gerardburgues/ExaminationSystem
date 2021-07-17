package com.SSD.SSD.repos;

import com.SSD.SSD.model.Question;
import com.SSD.SSD.model.Student;
import com.SSD.SSD.model.StudentQuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentQuestionAnswerRepository extends JpaRepository<StudentQuestionAnswer, Integer> {

    public Optional<StudentQuestionAnswer> findByStudentByStudentIdAndQuestionByQuestionId(Student student, Question question);
}
