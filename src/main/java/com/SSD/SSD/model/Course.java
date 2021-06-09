package com.SSD.SSD.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Course {
    private Integer courseId;
    private String name;
    private String description;
//    private Integer professorId;
    private Professor professorByProfessorId;
    private Collection<StudentCourse> studentCoursesByCourseId;
    private Collection<Tests> testsByCourseId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURSE_ID")
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    @Basic
//    @Column(name = "PROFESSOR_ID")
//    public Integer getProfessorId() {
//        return professorId;
//    }
//
//    public void setProfessorId(Integer professorId) {
//        this.professorId = professorId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (courseId != null ? !courseId.equals(course.courseId) : course.courseId != null) return false;
        if (name != null ? !name.equals(course.name) : course.name != null) return false;
        if (description != null ? !description.equals(course.description) : course.description != null) return false;
//        if (professorId != null ? !professorId.equals(course.professorId) : course.professorId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
//        result = 31 * result + (professorId != null ? professorId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PROFESSOR_ID", referencedColumnName = "PROFESSOR_ID")
    public Professor getProfessorByProfessorId() {
        return professorByProfessorId;
    }

    public void setProfessorByProfessorId(Professor professorByProfessorId) {
        this.professorByProfessorId = professorByProfessorId;
    }

    @OneToMany(mappedBy = "courseByCourseId")
    public Collection<StudentCourse> getStudentCoursesByCourseId() {
        return studentCoursesByCourseId;
    }

    public void setStudentCoursesByCourseId(Collection<StudentCourse> studentCoursesByCourseId) {
        this.studentCoursesByCourseId = studentCoursesByCourseId;
    }

    @OneToMany(mappedBy = "courseByCourseId")
    public Collection<Tests> getTestsByCourseId() {
        return testsByCourseId;
    }

    public void setTestsByCourseId(Collection<Tests> testsByCourseId) {
        this.testsByCourseId = testsByCourseId;
    }
}
