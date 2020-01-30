package com.app.zofeservice.service.impl;

import com.app.zofeservice.dto.QuestionInputDTO;
import com.app.zofeservice.dto.QuestionOutputDto;
import com.app.zofeservice.exception.ResourceNotFoundException;
import com.app.zofeservice.modal.Answer;
import com.app.zofeservice.modal.Question;
import com.app.zofeservice.repository.AnswerRepository;
import com.app.zofeservice.repository.QuestionRepository;
import com.app.zofeservice.service.QuestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Shameera.A on 1/26/2020
 */

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public List<QuestionOutputDto> getAllQuestions() {
        List<QuestionOutputDto> result = new ArrayList<>();
        List<Question> all = questionRepository.findAll();
        for (Question question : all) {
            QuestionOutputDto outputDto = new QuestionOutputDto();
            outputDto.setId(question.getId());
            outputDto.setQuestion(question.getQuestion());
            outputDto.setAnswers(question.getAnswers());
            result.add(outputDto);
        }
        return result;
    }

    @Override
    public void saveQuestion(QuestionInputDTO questionInputDTO) {
        List<Answer> answers = getAnswerList(questionInputDTO.getAnswers());
        answerRepository.saveAll(answers);
        questionRepository.save(Question.builder().question(questionInputDTO.getQuestion()).answers(answers).build());
    }

    private List<Answer> getAnswerList(String answerString){
        List<Answer> answersList = new ArrayList<>();
        String[] answerArr = answerString.split(",");

        for (int i = 0; i < answerArr.length; i++) {
            answersList.add(Answer.builder().answerText(answerArr[i]).answerScore(i).build());
        }
        return answersList;
    }

    @Override
    public void deleteQuestionById(long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public QuestionOutputDto getQuestionById(long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No question found for given id")).viewQuestionDetails();
    }

    @Transactional
    @Override
    public void updateQuestion(long id,QuestionInputDTO questionInputDTO) {
        Question question = questionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No question found for given id"));

      /* may be have to save the new answers to answer table*/

        questionRepository.updateQuestion(questionInputDTO.getQuestion(),getAnswerList(questionInputDTO.getAnswers()),question.getId());
    }
}
