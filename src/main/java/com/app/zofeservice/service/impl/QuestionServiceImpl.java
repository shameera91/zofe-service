package com.app.zofeservice.service.impl;

import com.app.zofeservice.dto.QuestionInputDTO;
import com.app.zofeservice.modal.Answer;
import com.app.zofeservice.modal.Question;
import com.app.zofeservice.repository.AnswerRepository;
import com.app.zofeservice.repository.QuestionRepository;
import com.app.zofeservice.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Shameera.A on 1/26/2020
 */

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository,AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(int questionIdx) {
        return null;
    }

    @Override
    public void saveQuestion(QuestionInputDTO questionInputDTO) {
        List<Answer> answersList = new ArrayList<>();

        String answersString = questionInputDTO.getAnswers();
        String[] answerArr = answersString.split(",");

        for (int i = 0; i < answerArr.length; i++) {
            answersList.add(Answer.builder().answerText(answerArr[i]).answerScore(i).build());
        }
        answerRepository.saveAll(answersList);
        questionRepository.save(Question.builder().question(questionInputDTO.getQuestion()).answers(answersList).build());
    }
}
