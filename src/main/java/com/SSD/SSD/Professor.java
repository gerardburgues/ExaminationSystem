package com.SSD.SSD;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;
@Entity
@Table(name="Professor")
public class Professor {



    @Id
    @SequenceGenerator(
            name="professor_sequence",
            sequenceName = "professor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "professor_sequence"

    )
    @Column(
            name="id",
            updatable = false
    )
    private  Long id;





    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;


    @OneToMany(mappedBy = "professor_id",
            cascade =CascadeType.ALL,
            orphanRemoval = true
        )
    private List<Course> course = new ArrayList<>();


    @ManyToMany(mappedBy = "professor_id")
    private List<Department> department = new ArrayList<>();





    public Professor() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "PROFESSOR_ID=" + id +


                '}';
    }
}
