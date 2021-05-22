package com.SSD.SSD;

import javax.persistence.*;
import java.util.UUID;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="StudentTest")
public class StudentTest {

    @Id
    @SequenceGenerator(
            name="studenttest_sequence",
            sequenceName = "studenttest_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "studenttest_sequence"

    )
    @Column(
            name="id",
            updatable = false
    )
    private Long  id;
    @Column(
            name="MARK",
            nullable = false

    )
    private  Double MARK;

    @ManyToOne
    @JoinColumn(name="test_id", referencedColumnName = "id")
    private   Test test_id;

    @ManyToOne
    @JoinColumn(name="student_id", referencedColumnName = "id")
    private   Student student_id;



}
