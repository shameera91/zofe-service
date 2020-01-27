package com.app.zofeservice.repository;

import com.app.zofeservice.modal.Employee;
import com.app.zofeservice.modal.QuestionnaireAnswers;

import java.util.List;
import java.util.Map;

/**
 * Created By Shameera.A on 1/27/2020
 */
public interface QnARepositoryCustom {

    List<QuestionnaireAnswers> getAllFittingCandidates(Map<Long, Integer> questionList);
}
