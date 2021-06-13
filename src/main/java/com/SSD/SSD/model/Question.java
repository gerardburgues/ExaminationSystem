package com.SSD.SSD.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Question {
    private Integer questionId;
//    private Integer questionTypeId;
//    private Integer testId;
    private Collection<Answer> answersByQuestionId;
    private QuestionType questionTypeByQuestionTypeId;
    private Tests testByTestId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTION_ID")
    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

//    @Basic
//    @Column(name = "QUESTIONTYPE_ID")
//    public Integer getQuestionTypeId() {
//        return questionTypeId;
//    }
//
//    public void setQuestionTypeId(Integer questionTypeId) {
//        this.questionTypeId = questionTypeId;
//    }
//
//    @Basic
//    @Column(name = "TEST_ID")
//    public Integer getTestId() {
//        return testId;
//    }
//
//    public void setTestId(Integer testId) {
//        this.testId = testId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (questionId != null ? !questionId.equals(question.questionId) : question.questionId != null) return false;
//        if (questionTypeId != null ? !questionTypeId.equals(question.questionTypeId) : question.questionTypeId != null)
//            return false;
//        if (testId != null ? !testId.equals(question.testId) : question.testId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionId != null ? questionId.hashCode() : 0;
//        result = 31 * result + (questionTypeId != null ? questionTypeId.hashCode() : 0);
//        result = 31 * result + (testId != null ? testId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "questionByQuestionId", cascade = {CascadeType.REMOVE})
    public Collection<Answer> getAnswersByQuestionId() {
        return answersByQuestionId;
    }

    public void setAnswersByQuestionId(Collection<Answer> answersByQuestionId) {
        this.answersByQuestionId = answersByQuestionId;
    }

    @ManyToOne
    @JoinColumn(name = "QUESTIONTYPE_ID", referencedColumnName = "QUESTIONTYPE_ID", nullable = false)
    public QuestionType getQuestionTypeByQuestionTypeId() {
        return questionTypeByQuestionTypeId;
    }

    public void setQuestionTypeByQuestionTypeId(QuestionType questionTypeByQuestionTypeId) {
        this.questionTypeByQuestionTypeId = questionTypeByQuestionTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "TEST_ID", referencedColumnName = "TEST_ID", nullable = false)
    public Tests getTestByTestId() {
        return testByTestId;
    }

    public void setTestByTestId(Tests testByTestId) {
        this.testByTestId = testByTestId;
    }
}
