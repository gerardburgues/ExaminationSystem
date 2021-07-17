package com.SSD.SSD.model;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints=
@UniqueConstraint(columnNames={"TEST_ID", "STUDENT_ID"}))
public class StudentTest {
    private Integer studentTestId;
    private Double mark;
    //    private Integer testId;
//    private Integer studentId;
    private Tests testByTestId;
    private Student studentByStudentId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENTTEST_ID")
    public Integer getStudentTestId() {
        return studentTestId;
    }

    public void setStudentTestId(Integer studentTestId) {
        this.studentTestId = studentTestId;
    }

    @Basic
    @Column(name = "MARK")
    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

//    @Basic
//    @Column(name = "TEST_ID")
//    public Integer getTestId() {
//        return testId;
//    }
//
//    public void setTestId(Integer testId) {
//        this.testId = testId;
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

        StudentTest that = (StudentTest) o;

        if (studentTestId != null ? !studentTestId.equals(that.studentTestId) : that.studentTestId != null)
            return false;
        if (mark != null ? !mark.equals(that.mark) : that.mark != null) return false;
//        if (testId != null ? !testId.equals(that.testId) : that.testId != null) return false;
//        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentTestId != null ? studentTestId.hashCode() : 0;
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
//        result = 31 * result + (testId != null ? testId.hashCode() : 0);
//        result = 31 * result + (studentId != null ? studentId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "TEST_ID", referencedColumnName = "TEST_ID", nullable = false)
    public Tests getTestByTestId() {
        return testByTestId;
    }

    public void setTestByTestId(Tests testByTestId) {
        this.testByTestId = testByTestId;
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
