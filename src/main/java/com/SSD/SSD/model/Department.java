package com.SSD.SSD.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
public class Department {
    private Integer departmentId;
    private String name;
    private Collection<Professor> professorsByDepartmentId;
    private Collection<StudentDepartment> studentDepartmentsByDepartmentId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPARTMENT_ID")
    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (departmentId != null ? !departmentId.equals(that.departmentId) : that.departmentId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = departmentId != null ? departmentId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "departmentByDepartmentId")
    public Collection<Professor> getProfessorsByDepartmentId() {
        return professorsByDepartmentId;
    }

    public void setProfessorsByDepartmentId(Collection<Professor> professorsByDepartmentId) {
        this.professorsByDepartmentId = professorsByDepartmentId;
    }

    @OneToMany(mappedBy = "departmentByDepartmentId")
    public Collection<StudentDepartment> getStudentDepartmentsByDepartmentId() {
        return studentDepartmentsByDepartmentId;
    }

    public void setStudentDepartmentsByDepartmentId(Collection<StudentDepartment> studentDepartmentsByDepartmentId) {
        this.studentDepartmentsByDepartmentId = studentDepartmentsByDepartmentId;
    }
}
