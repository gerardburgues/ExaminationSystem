package com.SSD.SSD.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Professor implements Serializable {

    private Long professorId;
    private Long userId;
    private Long departmentId;


    @Id
    @Column(name = "PROFESSOR_ID", nullable = false)
    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    @Basic
    @Column(name = "USER_ID", nullable = false)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "DEPARTMENT_ID", nullable = false)
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(professorId, professor.professorId) && Objects.equals(userId, professor.userId) && Objects.equals(departmentId, professor.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(professorId, userId, departmentId);
    }
}
