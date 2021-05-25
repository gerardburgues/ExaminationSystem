package com.SSD.SSD.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Studenttest implements Serializable {

    private Long studenttestId;
    private Double mark;
    private Long testId;
    private Long studentId;


    @Id
    @Column(name = "STUDENTTEST_ID", nullable = false)
    public Long getStudenttestId() {
        return studenttestId;
    }

    public void setStudenttestId(Long studenttestId) {
        this.studenttestId = studenttestId;
    }

    @Basic
    @Column(name = "MARK", nullable = true, precision = 0)
    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    @Basic
    @Column(name = "TEST_ID", nullable = false)
    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    @Basic
    @Column(name = "STUDENT_ID", nullable = false)
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studenttest that = (Studenttest) o;
        return Objects.equals(studenttestId, that.studenttestId) && Objects.equals(mark, that.mark) && Objects.equals(testId, that.testId) && Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studenttestId, mark, testId, studentId);
    }
}
