package com.SSD.SSD.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Question implements Serializable {

    private Long questionId;
    private Long questiontypeId;
    private Long testId;


    @Id
    @Column(name = "QUESTION_ID", nullable = false)
    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "QUESTIONTYPE_ID", nullable = false)
    public Long getQuestiontypeId() {
        return questiontypeId;
    }

    public void setQuestiontypeId(Long questiontypeId) {
        this.questiontypeId = questiontypeId;
    }

    @Basic
    @Column(name = "TEST_ID", nullable = false)
    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(questionId, question.questionId) && Objects.equals(questiontypeId, question.questiontypeId) && Objects.equals(testId, question.testId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, questiontypeId, testId);
    }
}
