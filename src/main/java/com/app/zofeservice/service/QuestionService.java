package com.app.zofeservice.service;

import com.app.zofeservice.dto.QuestionInputDTO;
import com.app.zofeservice.dto.QuestionOutputDto;

import java.util.List;

/**
 * Created By Shameera.A on 1/26/2020
 */
public interface QuestionService {

    List<QuestionOutputDto> getAllQuestions();

    QuestionOutputDto getQuestionById(long id);

    void saveQuestion(QuestionInputDTO questionInputDTO);

    void deleteQuestionById(long id);

    void updateQuestion(long id,QuestionInputDTO questionInputDTO);

}
