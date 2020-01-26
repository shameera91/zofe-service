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
    public List<CandidateOutputDTO> getMatchingClientsByAnswerIndex(String searchQuery) {

        /*   example searchQuery     String searchQuery = "1:1,2:3"     */

        /* what I m thinking is , from from end we are passing , question id and answer which
        * the employer is picking .
        *
        * in here we have to separate into parts ,  by using java String class functions
        *
        * after that , we have to do the filtering part.
        *
        * which is I m still thinking
        *
        * */


        return null;
    }
}
