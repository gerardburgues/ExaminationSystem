package com.SSD.SSD;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="Test")
public class Test {

    @Id
    @SequenceGenerator(
            name="test_sequence",
            sequenceName = "test_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "test_sequence"

    )
    @Column(
            name="id",
            updatable = false
    )
    private  Long id;
    @Column(
            name="startdate",
            nullable = false

    )
    private  Date STARTDATE;
    @Column(
            name="starttime",
            nullable = false

    )
    private  Timestamp STARTTIME;
    @Column(
            name="durationminutes",
            nullable = false

    )
    private  Integer DURATIONMINUTES ;

    @ManyToMany
    @JoinTable(
            name="course_test",
            joinColumns = @JoinColumn(name="test_id"),
            inverseJoinColumns = @JoinColumn(name="course_id")
    )
    private List<Course> course_id = new ArrayList<>();

    @OneToMany(mappedBy = "test_id",
            cascade =CascadeType.ALL,
            orphanRemoval = true
    )
    private List<StudentTest> studentTests = new ArrayList<>();



    public Test(Long TEST_ID, Date STARTDATE, Timestamp STARTTIME, Integer DURATIONMINUTES) {
        this.id = TEST_ID;
        this.STARTDATE = STARTDATE;
        this.STARTTIME = STARTTIME;
        this.DURATIONMINUTES = DURATIONMINUTES;

    }

    public Test() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSTARTDATE() {
        return STARTDATE;
    }

    public void setSTARTDATE(Date STARTDATE) {
        this.STARTDATE = STARTDATE;
    }

    public Timestamp getSTARTTIME() {
        return STARTTIME;
    }

    public void setSTARTTIME(Timestamp STARTTIME) {
        this.STARTTIME = STARTTIME;
    }

    public Integer getDURATIONMINUTES() {
        return DURATIONMINUTES;
    }

    public void setDURATIONMINUTES(Integer DURATIONMINUTES) {
        this.DURATIONMINUTES = DURATIONMINUTES;
    }





    @Override
    public String toString() {
        return "Test{" +
                "TEST_ID=" + id +
                ", STARTDATE=" + STARTDATE +
                ", STARTTIME=" + STARTTIME +
                ", DURATIONMINUTES=" + DURATIONMINUTES +

                '}';
    }
}
