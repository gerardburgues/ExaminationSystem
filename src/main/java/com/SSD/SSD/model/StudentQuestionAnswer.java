package com.SSD.SSD.model;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints=
@UniqueConstraint(columnNames={"STUDENT_ID", "QUESTION_ID"}))
public class StudentQuestionAnswer {
    private Integer studentAnswerId;
//    private Integer AnswerId;
//    private Integer studentId;
    private Answer answerByAnswerId;
    private Student studentByStudentId;
    private Question questionByQuestionId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENTANSWER_ID")
    public Integer getStudentAnswerId() {
        return studentAnswerId;
    }

    public void setStudentAnswerId(Integer studentAnswerId) {
        this.studentAnswerId = studentAnswerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentQuestionAnswer that = (StudentQuestionAnswer) o;

        if (studentAnswerId != null ? !studentAnswerId.equals(that.studentAnswerId) : that.studentAnswerId != null)
            return false;
//        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;
//        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentAnswerId != null ? studentAnswerId.hashCode() : 0;
//        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
//        result = 31 * result + (studentId != null ? studentId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ANSWER_ID", referencedColumnName = "ANSWER_ID", nullable = false)
    public Answer getAnswerByAnswerId() {
        return answerByAnswerId;
    }

    public void setAnswerByAnswerId(Answer answerByAnswerId) {
        this.answerByAnswerId = answerByAnswerId;
    }

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "STUDENT_ID", nullable = false)
    public Student getStudentByStudentId() {
        return studentByStudentId;
    }

    public void setStudentByStudentId(Student studentByStudentId) {
        this.studentByStudentId = studentByStudentId;
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

