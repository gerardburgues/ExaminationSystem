package com.SSD.SSD.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Studentdepartment implements Serializable {

    private Long studentsepartmentId;
    private Long departmentId;
    private Long studentId;


    @Id
    @Column(name = "STUDENTSEPARTMENT_ID", nullable = false)
    public Long getStudentsepartmentId() {
        return studentsepartmentId;
    }

    public void setStudentsepartmentId(Long studentsepartmentId) {
        this.studentsepartmentId = studentsepartmentId;
    }

    @Basic
    @Column(name = "DEPARTMENT_ID", nullable = false)
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
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
        Studentdepartment that = (Studentdepartment) o;
        return Objects.equals(studentsepartmentId, that.studentsepartmentId) && Objects.equals(departmentId, that.departmentId) && Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentsepartmentId, departmentId, studentId);
    }
}
