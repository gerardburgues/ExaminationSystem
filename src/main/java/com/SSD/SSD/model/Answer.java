package com.SSD.SSD.model;

import javax.persistence.*;

@Entity
public class Answer {
    private Integer answerId;
    private String value;
    private Boolean isCorrect;
//    private Integer questionId;
    private Question questionByQuestionId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ANSWER_ID")
    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    @Basic
    @Column(name = "VALUE")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Basic
    @Column(name = "ISCORRECT")
    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

//    @Basic
//    @Column(name = "QUESTION_ID")
//    public Integer getQuestionId() {
//        return questionId;
//    }
//
//    public void setQuestionId(Integer questionId) {
//        this.questionId = questionId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        if (answerId != null ? !answerId.equals(answer.answerId) : answer.answerId != null) return false;
        if (value != null ? !value.equals(answer.value) : answer.value != null) return false;
        if (isCorrect != null ? !isCorrect.equals(answer.isCorrect) : answer.isCorrect != null) return false;
//        if (questionId != null ? !questionId.equals(answer.questionId) : answer.questionId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = answerId != null ? answerId.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (isCorrect != null ? isCorrect.hashCode() : 0);
//        result = 31 * result + (questionId != null ? questionId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID", referencedColumnName = "QUESTION_ID", nullable = false)
    public Question getQuestionByQuestionId() {
        return questionByQuestionId;
    }

    public void setQuestionByQuestionId(Question questionByQuestionId) {
        this.questionByQuestionId = questionByQuestionId;
    }
}
