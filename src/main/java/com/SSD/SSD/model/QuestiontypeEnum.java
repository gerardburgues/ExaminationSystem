package com.SSD.SSD.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "QUESTIONTYPE_ENUM", schema = "PUBLIC", catalog = "USERS")
public class QuestiontypeEnum implements Serializable {

    private Long questiontypeId;
    private String name;


    @Id
    @Column(name = "QUESTIONTYPE_ID", nullable = false)
    public Long getQuestiontypeId() {
        return questiontypeId;
    }

    public void setQuestiontypeId(Long questiontypeId) {
        this.questiontypeId = questiontypeId;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestiontypeEnum that = (QuestiontypeEnum) o;
        return Objects.equals(questiontypeId, that.questiontypeId) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questiontypeId, name);
    }
}
