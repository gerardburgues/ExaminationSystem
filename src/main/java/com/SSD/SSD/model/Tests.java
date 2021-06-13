package com.SSD.SSD.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

@Entity
public class Tests {

    private Integer testId;
    private String testName;
    private LocalDate startDate;
    private LocalTime startTime;
    private Integer durationMinutes;
//    private Integer courseId;
    private Collection<Question> questionsByTestId;
    private Collection<StudentTest> studentTestsByTestId;
    private Course courseByCourseId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEST_ID")
    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    @Basic
    @Column(name = "TEST_NAME")
    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    @Basic
    @Column(name = "STARTDATE")
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "STARTTIME")
    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "DURATIONMINUTES")
    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tests test = (Tests) o;

        if (testId != null ? !testId.equals(test.testId) : test.testId != null) return false;
        if (startDate != null ? !startDate.equals(test.startDate) : test.startDate != null) return false;
        if (startTime != null ? !startTime.equals(test.startTime) : test.startTime != null) return false;
        if (durationMinutes != null ? !durationMinutes.equals(test.durationMinutes) : test.durationMinutes != null)
            return false;
        if (testName != null ? !testName.equals(test.testName) : test.testName != null) return false;
//        if (courseId != null ? !courseId.equals(test.courseId) : test.courseId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = testId != null ? testId.hashCode() : 0;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (durationMinutes != null ? durationMinutes.hashCode() : 0);
        result = 31 * result + (testName != null ? testName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "testByTestId", cascade = {CascadeType.REMOVE})
    public Collection<Question> getQuestionsByTestId() {
        return questionsByTestId;
    }

    public void setQuestionsByTestId(Collection<Question> questionsByTestId) {
        this.questionsByTestId = questionsByTestId;
    }

    @OneToMany(mappedBy = "testByTestId", cascade = {CascadeType.REMOVE})
    public Collection<StudentTest> getStudentTestsByTestId() {
        return studentTestsByTestId;
    }

    public void setStudentTestsByTestId(Collection<StudentTest> studentTestsByTestId) {
        this.studentTestsByTestId = studentTestsByTestId;
    }

    @ManyToOne
    @JoinColumn(name = "COURSE_ID", referencedColumnName = "COURSE_ID", nullable = false)
    public Course getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(Course courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }
}
