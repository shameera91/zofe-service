package com.app.zofeservice.controller;

import com.app.zofeservice.dto.QuestionInputDTO;
import com.app.zofeservice.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> getQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @PostMapping(value = "/save-question")
    public ResponseEntity<?> saveQuestionAndAnswers(@RequestBody QuestionInputDTO questionInputDTO) {
        questionService.saveQuestion(questionInputDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
