package com.SSD.SSD.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Test implements Serializable {

    private Long testId;
    private Date startdate;
    private Timestamp starttime;
    private Long durationminutes;
    private Long courseId;


    @Id
    @Column(name = "TEST_ID", nullable = false)
    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    @Basic
    @Column(name = "STARTDATE", nullable = false)
    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    @Basic
    @Column(name = "STARTTIME", nullable = false)
    public Timestamp getStarttime() {
        return starttime;
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    @Basic
    @Column(name = "DURATIONMINUTES", nullable = false)
    public Long getDurationminutes() {
        return durationminutes;
    }

    public void setDurationminutes(Long durationminutes) {
        this.durationminutes = durationminutes;
    }

    @Basic
    @Column(name = "COURSE_ID", nullable = false)
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(testId, test.testId) && Objects.equals(startdate, test.startdate) && Objects.equals(starttime, test.starttime) && Objects.equals(durationminutes, test.durationminutes) && Objects.equals(courseId, test.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(testId, startdate, starttime, durationminutes, courseId);
    }
}
