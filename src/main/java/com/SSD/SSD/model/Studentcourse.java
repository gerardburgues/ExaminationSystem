package com.SSD.SSD.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Studentcourse implements Serializable {

    private Long studentcourseId;
    private Double finalgrade;
    private Long courseId;
    private Long studentId;


    @Id
    @Column(name = "STUDENTCOURSE_ID", nullable = false)
    public Long getStudentcourseId() {
        return studentcourseId;
    }

    public void setStudentcourseId(Long studentcourseId) {
        this.studentcourseId = studentcourseId;
    }

    @Basic
    @Column(name = "FINALGRADE", nullable = true, precision = 0)
    public Double getFinalgrade() {
        return finalgrade;
    }

    public void setFinalgrade(Double finalgrade) {
        this.finalgrade = finalgrade;
    }

    @Basic
    @Column(name = "COURSE_ID", nullable = false)
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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
        Studentcourse that = (Studentcourse) o;
        return Objects.equals(studentcourseId, that.studentcourseId) && Objects.equals(finalgrade, that.finalgrade) && Objects.equals(courseId, that.courseId) && Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentcourseId, finalgrade, courseId, studentId);
    }
}
