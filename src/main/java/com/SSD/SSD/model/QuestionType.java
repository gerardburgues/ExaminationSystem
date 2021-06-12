package com.SSD.SSD.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "QUESTIONTYPE")
public class QuestionType {
    private Integer questionTypeId;
    private String name;
    private Collection<Question> questionsByQuestiontypeId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTIONTYPE_ID")
    public Integer getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(Integer questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    @Basic
    @Column(name = "NAME")
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

        QuestionType that = (QuestionType) o;

        if (questionTypeId != null ? !questionTypeId.equals(that.questionTypeId) : that.questionTypeId != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionTypeId != null ? questionTypeId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "questionTypeByQuestionTypeId")
    public Collection<Question> getQuestionsByQuestiontypeId() {
        return questionsByQuestiontypeId;
    }

    public void setQuestionsByQuestiontypeId(Collection<Question> questionsByQuestiontypeId) {
        this.questionsByQuestiontypeId = questionsByQuestiontypeId;
    }
}
