package com.app.zofeservice.service;

import com.app.zofeservice.modal.Question;

import java.util.List;

/**
 * Created By Shameera.A on 1/26/2020
 */
public interface QuestionService {

    List<Question> getAllQuestions();  /* replace with output dto*/

    Question getQuestionById(int questionIdx);
}
