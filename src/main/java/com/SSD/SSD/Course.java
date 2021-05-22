package com.SSD.SSD;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="Course")

public class Course {


    @Id
    @SequenceGenerator(
            name="course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "course_sequence"

    )
    @Column(
            name="id",
            updatable = false
    )
    private  Long Id;
    @Column(
            name="NAME",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private  String NAME;
    @Column(
            name="DESCRIPTION",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private  String DESCRIPTION;

    @ManyToOne
    @JoinColumn(name="professor_id", referencedColumnName = "id")
    private   Professor professor_id;

    @ManyToMany(mappedBy = "course_id")
    private List<Test> tests = new ArrayList<>();


    public Course(Long id, String NAME, String DESCRIPTION, Professor PROFESSOR_ID) {
        Id = id;
        this.NAME = NAME;
        this.DESCRIPTION = DESCRIPTION;
        this.professor_id = PROFESSOR_ID;
    }

    public Course() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public Professor getPROFESSOR_ID() {
        return professor_id;
    }

    public void setPROFESSOR_ID(Professor PROFESSOR_ID) {
        this.professor_id = PROFESSOR_ID;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Id=" + Id +
                ", NAME='" + NAME + '\'' +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                ", PROFESSOR_ID=" + professor_id +
                '}';
    }
}
