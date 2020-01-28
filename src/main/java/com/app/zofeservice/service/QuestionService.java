package com.app.zofeservice.service;

import com.app.zofeservice.dto.QuestionInputDTO;
import com.app.zofeservice.dto.QuestionOutputDto;
import com.app.zofeservice.modal.Question;

import java.util.List;

/**
 * Created By Shameera.A on 1/26/2020
 */
public interface QuestionService {

    List<QuestionOutputDto> getAllQuestions();

    Question getQuestionById(int questionIdx);

    void saveQuestion(QuestionInputDTO questionInputDTO);
}
