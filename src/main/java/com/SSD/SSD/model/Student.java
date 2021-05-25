package com.SSD.SSD.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Student implements Serializable {

    private Long studentId;
    private Long indexNo;
    private Long userId;


    @Id
    @Column(name = "STUDENT_ID", nullable = false)
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "INDEX_NO", nullable = true)
    public Long getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(Long indexNo) {
        this.indexNo = indexNo;
    }

    @Basic
    @Column(name = "USER_ID", nullable = false)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId) && Objects.equals(indexNo, student.indexNo) && Objects.equals(userId, student.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, indexNo, userId);
    }
}
