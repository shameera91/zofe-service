package com.app.zofeservice.service.impl;

import com.app.zofeservice.modal.Question;
import com.app.zofeservice.repository.QuestionRepository;
import com.app.zofeservice.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By Shameera.A on 1/26/2020
 */

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}
