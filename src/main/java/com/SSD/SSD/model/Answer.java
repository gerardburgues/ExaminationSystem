package com.SSD.SSD.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Answer implements Serializable {

    private Long answerId;
    private String value;
    private Boolean iscorrect;
    private Long questionId;

    @Id
    @Column(name = "ANSWER_ID", nullable = false)
    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    @Basic
    @Column(name = "VALUE", nullable = false, length = 100)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Basic
    @Column(name = "ISCORRECT", nullable = false)
    public Boolean getIscorrect() {
        return iscorrect;
    }

    public void setIscorrect(Boolean iscorrect) {
        this.iscorrect = iscorrect;
    }

    @Basic
    @Column(name = "QUESTION_ID", nullable = false)
    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(answerId, answer.answerId) && Objects.equals(value, answer.value) && Objects.equals(iscorrect, answer.iscorrect) && Objects.equals(questionId, answer.questionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerId, value, iscorrect, questionId);
    }
}
