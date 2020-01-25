package com.app.zofeservice.service.impl;

import com.app.zofeservice.dto.CandidateOutputDTO;
import com.app.zofeservice.modal.QuestionnaireAnswers;
import com.app.zofeservice.repository.QuestionnaireAnswerRepository;
import com.app.zofeservice.service.QuestionnaireService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By Shameera.A on 1/25/2020
 */

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
    private final QuestionnaireAnswerRepository questionnaireAnswerRepository;

    public QuestionnaireServiceImpl(QuestionnaireAnswerRepository questionnaireAnswerRepository) {
        this.questionnaireAnswerRepository = questionnaireAnswerRepository;
    }

    @Override
    public List<CandidateOutputDTO> getMatchingClientsByAnswerIndex(int idx) {

        List<QuestionnaireAnswers> matchingResult = questionnaireAnswerRepository.getMatchingEmployeeByAnswerIndex(idx);
        /*setting the data to be sent to front end*/
        /*match level*/
        return null;
    }
}
