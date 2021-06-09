package com.SSD.SSD.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Professor {
    private Integer professorId;
//    private Integer userId;
//    private Integer departmentId;
    private Collection<Course> coursesByProfessorId;
    private Users userByUserId;
    private Department departmentByDepartmentId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROFESSOR_ID")
    public Integer getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Integer professorId) {
        this.professorId = professorId;
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
//
//    @Basic
//    @Column(name = "DEPARTMENT_ID")
//    public Integer getDepartmentId() {
//        return departmentId;
//    }
//
//    public void setDepartmentId(Integer departmentId) {
//        this.departmentId = departmentId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Professor professor = (Professor) o;

        if (professorId != null ? !professorId.equals(professor.professorId) : professor.professorId != null)
            return false;
//        if (userId != null ? !userId.equals(professor.userId) : professor.userId != null) return false;
//        if (departmentId != null ? !departmentId.equals(professor.departmentId) : professor.departmentId != null)
//            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = professorId != null ? professorId.hashCode() : 0;
//        result = 31 * result + (userId != null ? userId.hashCode() : 0);
//        result = 31 * result + (departmentId != null ? departmentId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "professorByProfessorId")
    public Collection<Course> getCoursesByProfessorId() {
        return coursesByProfessorId;
    }

    public void setCoursesByProfessorId(Collection<Course> coursesByProfessorId) {
        this.coursesByProfessorId = coursesByProfessorId;
    }

    @OneToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false)
    public Users getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(Users userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID", nullable = false)
    public Department getDepartmentByDepartmentId() {
        return departmentByDepartmentId;
    }

    public void setDepartmentByDepartmentId(Department departmentByDepartmentId) {
        this.departmentByDepartmentId = departmentByDepartmentId;
    }
}
