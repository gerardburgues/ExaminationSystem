package com.SSD.SSD.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Users {
    private Integer userId;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Integer pesel;
    private Collection<Professor> professorsByUserId;
    private Collection<Student> studentsByUserId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "SURNAME")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "PESEL")
    public Integer getPesel() {
        return pesel;
    }

    public void setPesel(Integer pesel) {
        this.pesel = pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users user = (Users) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (pesel != null ? !pesel.equals(user.pesel) : user.pesel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (pesel != null ? pesel.hashCode() : 0);
        return result;
    }
//
//    @OneToOne(mappedBy = "userByUserId")
//    public Collection<Professor> getProfessorsByUserId() {
//        return professorsByUserId;
//    }
//
//    public void setProfessorsByUserId(Collection<Professor> professorsByUserId) {
//        this.professorsByUserId = professorsByUserId;
//    }
//
//    @OneToOne(mappedBy = "userByUserId")
//    public Collection<Student> getStudentsByUserId() {
//        return studentsByUserId;
//    }
//
//    public void setStudentsByUserId(Collection<Student> studentsByUserId) {
//        this.studentsByUserId = studentsByUserId;
//    }
}
