package com.SSD.SSD.model;

import javax.persistence.*;
import java.util.Collection;

@Entity

public class Student {
    private Integer studentId;
    private Integer indexNo;
//    private Integer userId;
    private Users userByUserId;
    private Collection<StudentCourse> studentCoursesByStudentId;
    private Collection<StudentDepartment> studentDepartmentsByStudentId;
    private Collection<StudentTest> studentTestsByStudentId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID")
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "INDEX_NO")
    public Integer getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(Integer indexNo) {
        this.indexNo = indexNo;
    }

//    @Basic
//    @Column(name = "USER_ID")
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (studentId != null ? !studentId.equals(student.studentId) : student.studentId != null) return false;
        if (indexNo != null ? !indexNo.equals(student.indexNo) : student.indexNo != null) return false;
//        if (userId != null ? !userId.equals(student.userId) : student.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + (indexNo != null ? indexNo.hashCode() : 0);
//        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false)
    public Users getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(Users userByUserId) {
        this.userByUserId = userByUserId;
    }

    @OneToMany(mappedBy = "studentByStudentId")
    public Collection<StudentCourse> getStudentCoursesByStudentId() {
        return studentCoursesByStudentId;
    }

    public void setStudentCoursesByStudentId(Collection<StudentCourse> studentCoursesByStudentId) {
        this.studentCoursesByStudentId = studentCoursesByStudentId;
    }

    @OneToMany(mappedBy = "studentByStudentId")
    public Collection<StudentDepartment> getStudentDepartmentsByStudentId() {
        return studentDepartmentsByStudentId;
    }

    public void setStudentDepartmentsByStudentId(Collection<StudentDepartment> studentDepartmentsByStudentId) {
        this.studentDepartmentsByStudentId = studentDepartmentsByStudentId;
    }

    @OneToMany(mappedBy = "studentByStudentId")
    public Collection<StudentTest> getStudentTestsByStudentId() {
        return studentTestsByStudentId;
    }

    public void setStudentTestsByStudentId(Collection<StudentTest> studentTestsByStudentId) {
        this.studentTestsByStudentId = studentTestsByStudentId;
    }


}
