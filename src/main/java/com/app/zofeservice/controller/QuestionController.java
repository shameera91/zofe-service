package com.app.zofeservice.controller;

import com.app.zofeservice.dto.QuestionInputDTO;
import com.app.zofeservice.dto.QuestionOutputDto;
import com.app.zofeservice.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created By Shameera.A on 1/26/2020
 */

@RestController
@RequestMapping("api/v1/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<QuestionOutputDto>> getQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @PostMapping(value = "/save-question")
    public ResponseEntity<Void> saveQuestionAndAnswers(@RequestBody QuestionInputDTO questionInputDTO) {
        questionService.saveQuestion(questionInputDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<QuestionOutputDto> getQuestionById(@PathVariable long id) {
        return ResponseEntity.ok(questionService.getQuestionById(id));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable long id) {
        questionService.deleteQuestionById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<Void> updateQuestion(@PathVariable long id, @RequestBody QuestionInputDTO questionInputDTO) {
        questionService.updateQuestion(id, questionInputDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
