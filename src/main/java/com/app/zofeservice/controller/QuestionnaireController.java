package com.app.zofeservice.controller;

import com.app.zofeservice.dto.QuestionnaireAnswerInputDTO;
import com.app.zofeservice.service.QuestionnaireService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By Shameera.A on 1/25/2020
 */

@RestController
@RequestMapping("api/v1/questionnaire")
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;

    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @GetMapping("/employee-mapping")
    public ResponseEntity<?> getMatchingClientsByAnswerIndex(@RequestParam String searchQuery) {
        return ResponseEntity.ok(questionnaireService.getMatchingCandidatesByAnswerIndex(searchQuery));
    }

    @PostMapping("/save-emp-answers")
    public ResponseEntity<?> saveQuestionnaireAnswers(@RequestBody QuestionnaireAnswerInputDTO answerInputDTO){
        questionnaireService.saveQuestionsAndAnswersByEmployee(answerInputDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
