package com.SSD.SSD.model;

import javax.persistence.*;

@Entity
public class StudentCourse {
    private Integer studentCourseId;
    private Double finalGrade;
//    private Integer courseId;
//    private Integer studentId;
    private Course courseByCourseId;
    private Student studentByStudentId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENTCOURSE_ID")
    public Integer getStudentCourseId() {
        return studentCourseId;
    }

    public void setStudentCourseId(Integer studentCourseId) {
        this.studentCourseId = studentCourseId;
    }

    @Basic
    @Column(name = "FINALGRADE")
    public Double getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(Double finalGrade) {
        this.finalGrade = finalGrade;
    }

//    @Basic
//    @Column(name = "COURSE_ID")
//    public Integer getCourseId() {
//        return courseId;
//    }
//
//    public void setCourseId(Integer courseId) {
//        this.courseId = courseId;
//    }
//
//    @Basic
//    @Column(name = "STUDENT_ID")
//    public Integer getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(Integer studentId) {
//        this.studentId = studentId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentCourse that = (StudentCourse) o;

        if (studentCourseId != null ? !studentCourseId.equals(that.studentCourseId) : that.studentCourseId != null)
            return false;
        if (finalGrade != null ? !finalGrade.equals(that.finalGrade) : that.finalGrade != null) return false;
//        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;
//        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentCourseId != null ? studentCourseId.hashCode() : 0;
        result = 31 * result + (finalGrade != null ? finalGrade.hashCode() : 0);
//        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
//        result = 31 * result + (studentId != null ? studentId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "COURSE_ID", referencedColumnName = "COURSE_ID", nullable = false)
    public Course getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(Course courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "STUDENT_ID", nullable = false)
    public Student getStudentByStudentId() {
        return studentByStudentId;
    }

    public void setStudentByStudentId(Student studentByStudentId) {
        this.studentByStudentId = studentByStudentId;
    }
}
