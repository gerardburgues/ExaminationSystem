package com.SSD.SSD;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity(name= "USER")
@Table(name = "user")
public class User {
    @Id
    @SequenceGenerator(
            name="user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_sequence"

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
    @Column(
            name="SURNAME",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private  String SURNAME;
    @Column(
            name="EMAIL",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private  String EMAIL;
    @Column(
            name="PASSWORD",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private  String PASSWORD;
    @Column(
            name="PESEL",
            nullable = false

    )
    private  Double PESEL;

   @OneToOne(mappedBy = "user")
   private Professor professor;

   @OneToOne(mappedBy = "user")
   private Student student;


    public User( String NAME, String SURNAME, String EMAIL, String PASSWORD, Double PESELS) {

        this.NAME = NAME;
        this.SURNAME = SURNAME;
        this.EMAIL = EMAIL;
        this.PASSWORD = PASSWORD;
        this.PESEL = PESELS;
    }

    public User() {

    }

    public Long getUSER_ID() {
        return id;
    }

    public void setUSER_ID(Long USER_ID) {
        this.id = USER_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getSURNAME() {
        return SURNAME;
    }

    public void setSURNAME(String SURNAME) {
        this.SURNAME = SURNAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public Double getPESELS() {
        return PESEL;
    }

    public void setPESELS(Double PESELS) {
        this.PESEL = PESELS;
    }

    @Override
    public String toString() {
        return "User{" +
                "USER_ID=" + id +
                ", NAME='" + NAME + '\'' +
                ", SURNAME='" + SURNAME + '\'' +
                ", EMAIL='" + EMAIL + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", PESELS=" + PESEL +
                '}';
    }
}
