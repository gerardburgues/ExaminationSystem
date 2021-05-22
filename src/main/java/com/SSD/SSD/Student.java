package com.SSD.SSD;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="Student")
public class Student {

    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "student_sequence"

    )
    @Column(
            name="id",
            updatable = false
    )
    private  Long id;

    @Column(
            name="INDEX_NO",
            updatable = false
    )
    private  Integer INDEX_NO;

    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private  User user;


    @OneToMany(mappedBy = "student_id",
            cascade =CascadeType.ALL,
            orphanRemoval = true
    )
    private List<StudentTest> studentTests = new ArrayList<>();


    public Student(Long id, Integer INDEX_NO, User user) {
        this.id = id;
        this.INDEX_NO = INDEX_NO;
        this.user = user;
    }

    public Student() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getINDEX_NO() {
        return INDEX_NO;
    }

    public void setINDEX_NO(Integer INDEX_NO) {
        this.INDEX_NO = INDEX_NO;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", INDEX_NO=" + INDEX_NO +
                ", user=" + user +
                '}';
    }
}
