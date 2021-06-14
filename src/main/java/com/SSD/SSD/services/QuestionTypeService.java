package com.SSD.SSD.services;

import com.SSD.SSD.model.QuestionType;
import com.SSD.SSD.repos.QuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionTypeService {

    private final QuestionTypeRepository questionTypeRepository;

    @Autowired
    public QuestionTypeService(QuestionTypeRepository questionTypeRepository) {
        this.questionTypeRepository = questionTypeRepository;
    }

    public QuestionType findQuestionTypeById(Integer id){

        return questionTypeRepository.findById(id).get();
    }
}
