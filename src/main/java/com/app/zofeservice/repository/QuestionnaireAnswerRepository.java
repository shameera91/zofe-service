package com.app.zofeservice.repository;

import com.app.zofeservice.modal.QuestionnaireAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created By Shameera.A on 1/25/2020
 */
public interface QuestionnaireAnswerRepository extends JpaRepository<QuestionnaireAnswers,Long> {

    @Query("SELECT a FROM QuestionnaireAnswers a WHERE a.answerIndex >= ?1")
    List<QuestionnaireAnswers> getMatchingEmployeeByAnswerIndex(int filterIndex);

}
