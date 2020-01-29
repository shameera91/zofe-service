package com.app.zofeservice.service;

import com.app.zofeservice.dto.CandidateOutputDTO;
import com.app.zofeservice.dto.QuestionnaireAnswerInputDTO;

import java.util.List;

/**
 * Created By Shameera.A on 1/25/2020
 */
public interface QuestionnaireService {

    List<CandidateOutputDTO> getMatchingCandidatesByAnswerIndex(String searchQuery);

    void saveQuestionsAndAnswersByEmployee(QuestionnaireAnswerInputDTO answerInputDTO);
}
