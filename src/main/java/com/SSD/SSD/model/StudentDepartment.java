package com.SSD.SSD.model;

import javax.persistence.*;

@Entity
public class StudentDepartment {
    private Integer studentDepartmentId;
    //    private Integer departmentId;
//    private Integer studentId;
    private Department departmentByDepartmentId;
    private Student studentByStudentId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENTDEPARTMENT_ID")
    public Integer getStudentDepartmentId() {
        return studentDepartmentId;
    }

    public void setStudentDepartmentId(Integer studentDepartmentId) {
        this.studentDepartmentId = studentDepartmentId;
    }

//    @Basic
//    @Column(name = "DEPARTMENT_ID")
//    public Integer getDepartmentId() {
//        return departmentId;
//    }
//
//    public void setDepartmentId(Integer departmentId) {
//        this.departmentId = departmentId;
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

        StudentDepartment that = (StudentDepartment) o;

        if (studentDepartmentId != null ? !studentDepartmentId.equals(that.studentDepartmentId) : that.studentDepartmentId != null)
            return false;
//        if (departmentId != null ? !departmentId.equals(that.departmentId) : that.departmentId != null) return false;
//        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentDepartmentId != null ? studentDepartmentId.hashCode() : 0;
//        result = 31 * result + (departmentId != null ? departmentId.hashCode() : 0);
//        result = 31 * result + (studentId != null ? studentId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID", nullable = false)
    public Department getDepartmentByDepartmentId() {
        return departmentByDepartmentId;
    }

    public void setDepartmentByDepartmentId(Department departmentByDepartmentId) {
        this.departmentByDepartmentId = departmentByDepartmentId;
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
