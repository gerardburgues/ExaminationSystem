package com.SSD.SSD.services;

import com.SSD.SSD.model.Question;
import com.SSD.SSD.repos.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void saveQuestion(Question question){

        questionRepository.save(question);
    }
}
