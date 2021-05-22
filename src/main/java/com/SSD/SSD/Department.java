package com.SSD.SSD;

import javax.persistence.*;


import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="Department")
public class Department {
    @Id
    @SequenceGenerator(
            name="department_sequence",
            sequenceName = "department_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "department_sequence"

    )
    @Column(
            name="id",
            updatable = false
    )
    private  Long id;

    @Column(
            name="NAME",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private  String NAME;



    @ManyToMany
    @JoinTable(
            name="professor_department",
            joinColumns = @JoinColumn(name="department_id"),
            inverseJoinColumns = @JoinColumn(name="professor_id")
    )
    private List<Professor> professor_id = new ArrayList<>();



    public Department(Long id, String NAME) {
        this.id = id;
        this.NAME = NAME;
    }

    public Department() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", NAME='" + NAME + '\'' +
                '}';
    }
}
