package com.SSD.SSD.services;

import com.SSD.SSD.model.Tests;
import com.SSD.SSD.repos.TestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class TestsService {

    private final TestsRepository testsRepository;

    @Autowired
    public TestsService(TestsRepository testsRepository) {
        this.testsRepository = testsRepository;
    }

    public void saveTest(Tests test){

       testsRepository.save(test);
    }

    public Tests findTestById (Integer id){

        return testsRepository.findById(id).get();
    }

    public Collection<Tests> findAllTests(){

        return testsRepository.findAll();
    }

    public void deleteTest(Tests test){

        testsRepository.delete(test);
    }
}
