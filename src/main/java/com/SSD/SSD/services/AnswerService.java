package com.SSD.SSD.services;

import com.SSD.SSD.model.Answer;
import com.SSD.SSD.repos.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public void saveAnswer(Answer answer){

        answerRepository.save(answer);
    }
}
